package workforce_management.repository;

import workforce_management.entity.OvertimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OvertimeEntryRepository extends JpaRepository<OvertimeEntry, Long> {
}