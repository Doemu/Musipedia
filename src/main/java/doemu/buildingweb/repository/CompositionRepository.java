package doemu.buildingweb.repository;


//import ch.qos.logback.core.net.server.Client;
import doemu.buildingweb.entities.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionRepository extends JpaRepository <Composition, String>{
}
