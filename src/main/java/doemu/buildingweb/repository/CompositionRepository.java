package doemu.buildingweb.repository;


//import ch.qos.logback.core.net.server.Client;
import doemu.buildingweb.entities.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CompositionRepository extends JpaRepository <Composition, Long>{
    @Transactional
    public Composition findCompositionByCompositionName(String name);
    public boolean existsByCompositionName(String name);
}
