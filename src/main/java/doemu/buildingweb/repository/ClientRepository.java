package doemu.buildingweb.repository;


//import ch.qos.logback.core.net.server.Client;
import doemu.buildingweb.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Composition, String>{
}
