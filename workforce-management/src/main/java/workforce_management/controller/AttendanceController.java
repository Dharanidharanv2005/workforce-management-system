package workforce_management.controller;

import workforce_management.dto.ApiResponse;
import workforce_management.dto.ClockInRequest;
import workforce_management.dto.ClockOutRequest;
import workforce_management.entity.AttendanceLog;
import workforce_management.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // CLOCK IN
    @PostMapping("/clock-in")
    public ApiResponse clockIn(@RequestBody ClockInRequest request) {

        String message = attendanceService.clockIn(request);

        return new ApiResponse(message);
    }

    // CLOCK OUT
    @PostMapping("/clock-out")
    public ApiResponse clockOut(@RequestBody ClockOutRequest request) {

        String message = attendanceService.clockOut(request);

        return new ApiResponse(message);
    }

    // ACTIVE WORKERS
    @GetMapping("/active")
    public List<AttendanceLog> getActiveWorkers() {

        return attendanceService.getActiveWorkers();
    }
}