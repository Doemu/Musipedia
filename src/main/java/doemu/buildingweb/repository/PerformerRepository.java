package doemu.buildingweb.repository;

import doemu.buildingweb.entities.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer, String> {
}
