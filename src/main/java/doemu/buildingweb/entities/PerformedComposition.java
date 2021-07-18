package doemu.buildingweb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "performedcomposition", schema = "public")
//@IdClass(PerformedCompositionId.class)
public class PerformedComposition {

    @Id
    @Column(name = "pc_id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pc_id_seq")
    @SequenceGenerator(
            name = "pc_id_seq",
            sequenceName = "pc_id_seq",
            initialValue = 5,
            allocationSize = 1
    )
    private long id;

    @ManyToOne
    @JoinColumn(name = "composition_id")
    private Composition composition;
    @ManyToOne
    @JoinColumn(name = "performer_id")
    private Performer performer;

    public PerformedComposition(long id, Composition composition, Performer performer) {
        this.id = id;
        this.composition = composition;
        this.performer = performer;
    }

    public PerformedComposition(Composition composition, Performer performer) {
        this.composition = composition;
        this.performer = performer;

        /*this.composition.getPerformedCompositions().add(this);
        this.performer.getPerformedCompositions().add(this);*/
    }

    public PerformedComposition() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Composition getComposition() {
        return composition;
    }

    public void setComposition(Composition composition) {
        this.composition = composition;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    /*public PerformedComposition(String compositionName, String performerName) {
        this.compositionName = compositionName;
        this.performerName = performerName;
    }

    public PerformedComposition() {

    }

    public String getCompositionName() {
        return compositionName;
    }
    public String getPerformerName() {return performerName; }
    public void setCompositionName(String compositionName) {
        this.compositionName = compositionName;
    }
    public void setPerformerName(String performerName) { this.performerName = performerName; }

    @Override
    public String toString() {
        return "PerformedComposition{" +
                "compositionName='" + compositionName + '\'' +
                ", performerName='" + performerName + '\'' +
                '}';
    }*/
}
