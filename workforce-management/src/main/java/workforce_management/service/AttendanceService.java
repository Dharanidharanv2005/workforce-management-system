package workforce_management.service;

import workforce_management.dto.ClockInRequest;
import workforce_management.dto.ClockOutRequest;
import workforce_management.entity.AttendanceLog;
import workforce_management.entity.Site;
import workforce_management.entity.Worker;
import workforce_management.repository.AttendanceLogRepository;
import workforce_management.repository.SiteRepository;
import workforce_management.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    private final WorkerRepository workerRepository;
    private final SiteRepository siteRepository;
    private final AttendanceLogRepository attendanceLogRepository;

    public AttendanceService(
            WorkerRepository workerRepository,
            SiteRepository siteRepository,
            AttendanceLogRepository attendanceLogRepository
    ) {
        this.workerRepository = workerRepository;
        this.siteRepository = siteRepository;
        this.attendanceLogRepository = attendanceLogRepository;
    }

    // CLOCK IN
    public String clockIn(ClockInRequest request) {

        Worker worker = workerRepository.findById(request.getWorkerId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        Site site = siteRepository.findById(request.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site not found"));

        // prevent double clock in
        if (attendanceLogRepository
                .findByWorkerAndClockOutTimeIsNull(worker)
                .isPresent()) {

            throw new RuntimeException("Worker already clocked in");
        }

        AttendanceLog attendanceLog = AttendanceLog.builder()
                .worker(worker)
                .site(site)
                .clockInTime(LocalDateTime.now())
                .flagged(false)
                .build();

        attendanceLogRepository.save(attendanceLog);

        return "Worker clocked in successfully";
    }

    // CLOCK OUT
    public String clockOut(ClockOutRequest request) {

        Worker worker = workerRepository.findById(request.getWorkerId())
                .orElseThrow(() -> new RuntimeException("Worker not found"));

        AttendanceLog attendanceLog = attendanceLogRepository
                .findByWorkerAndClockOutTimeIsNull(worker)
                .orElseThrow(() -> new RuntimeException("Worker is not clocked in"));

        LocalDateTime clockOutTime = LocalDateTime.now();

        attendanceLog.setClockOutTime(clockOutTime);

        double totalHours = Duration.between(
                attendanceLog.getClockInTime(),
                clockOutTime
        ).toMinutes() / 60.0;

        attendanceLog.setTotalHoursWorked(totalHours);

        // overtime calculation
        double overtime = Math.max(0, totalHours - 8);

        attendanceLog.setOvertimeHours(overtime);

        // flag suspicious attendance
        if (totalHours > 16) {
            attendanceLog.setFlagged(true);
        }

        attendanceLogRepository.save(attendanceLog);

        return "Worker clocked out successfully";
    }

    // ACTIVE WORKERS
    public List<AttendanceLog> getActiveWorkers() {

        return attendanceLogRepository.findByClockOutTimeIsNull();
    }
}