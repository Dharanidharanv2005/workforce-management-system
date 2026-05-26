package workforce_management.repository;

import workforce_management.entity.AttendanceLog;
import workforce_management.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceLogRepository extends JpaRepository<AttendanceLog, Long> {

    Optional<AttendanceLog> findByWorkerAndClockOutTimeIsNull(Worker worker);

    List<AttendanceLog> findByClockOutTimeIsNull();
}