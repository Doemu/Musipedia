package doemu.buildingweb.entities;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "composition", schema = "public")
public class Composition {

    @Column(name = "composition_name")
    @Id
    private String compositionName;
    @OneToMany(mappedBy = "composition", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PerformedComposition> performedCompositions;

    public Composition(String compositionName) {
        this.compositionName = compositionName;
    }

    public Composition() {

    }

    public String getCompositionName() {
        return compositionName;
    }

    public void setCompositionName(String compositionName) {
        this.compositionName = compositionName;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "compositionName='" + compositionName + '\'' +
                '}';
    }
}
