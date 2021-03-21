package doemu.buildingweb.repository;

import doemu.buildingweb.entities.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface PerformerRepository extends JpaRepository<Performer, Long> {
    @Transactional
    public Performer findPerformerByPerformerName(String name);
}
