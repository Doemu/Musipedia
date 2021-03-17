package doemu.buildingweb.repository;

import doemu.buildingweb.entities.PerformedComposition;
import doemu.buildingweb.entities.PerformedCompositionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformedCompositionRepository extends JpaRepository<PerformedComposition, PerformedCompositionId> {
}
