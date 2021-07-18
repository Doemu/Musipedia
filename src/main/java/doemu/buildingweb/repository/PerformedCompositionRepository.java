package doemu.buildingweb.repository;

import com.sun.istack.NotNull;
import doemu.buildingweb.entities.PerformedComposition;
import io.micrometer.core.lang.NonNullApi;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformedCompositionRepository extends JpaRepository<PerformedComposition, Long> {
    List<PerformedComposition> findByOrderByCompositionAsc();
}

