package workforce_management.entity;

import workforce_management.enums.SettlementStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "overtime_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OvertimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;

    @OneToOne
    @JoinColumn(name = "attendance_id", nullable = false)
    private AttendanceLog attendanceLog;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double overtimeHours;

    @Column(nullable = false)
    private Double overtimeRateApplied;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private SettlementStatus settlementStatus = SettlementStatus.PENDING;
}