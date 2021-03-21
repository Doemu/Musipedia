package doemu.buildingweb.entities;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "composition", schema = "public")
public class Composition implements Serializable {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "composition_id_seq")
    @SequenceGenerator(
            name = "composition_id_seq",
            sequenceName = "composition_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    @Id
    private long id;

    @Column(name = "composition_name", unique = true)
    private String compositionName;

    @OneToMany(mappedBy = "composition", cascade = CascadeType.ALL)
    Set<PerformedComposition> performedCompositions;

    public Composition(long id, String compositionName) {
        this.id = id;
        this.compositionName = compositionName;
    }

    public Composition(String compositionName) {
        this.compositionName = compositionName;
    }

    public Composition(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompositionName() {
        return compositionName;
    }

    public void setCompositionName(String compositionName) {
        this.compositionName = compositionName;
    }

    public Set<PerformedComposition> getPerformedCompositions() {
        return performedCompositions;
    }

    public void setPerformedCompositions(Set<PerformedComposition> performedCompositions) {
        //this.performedCompositions = performedCompositions;
        this.performedCompositions.clear();
        if(performedCompositions!=null){
            this.performedCompositions.addAll(performedCompositions);
        }
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", compositionName='" + compositionName + '\'' +
                ", performedCompositions=" + performedCompositions +
                '}';
    }
}
