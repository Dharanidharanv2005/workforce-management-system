package workforce_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import workforce_management.enums.Designation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "workers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Designation designation;

    @Column(nullable = false)
    private BigDecimal dailyWageRate;

    @Column(nullable = false)
    private Boolean active = true;
}