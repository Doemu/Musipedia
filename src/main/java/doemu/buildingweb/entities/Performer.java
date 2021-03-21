package doemu.buildingweb.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "performer", schema = "public")
public class Performer {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "performer_id_seq")
    @SequenceGenerator(
            name = "performer_id_seq",
            sequenceName = "performer_id_seq",
            initialValue = 4,
            allocationSize = 1
    )
    private long id;

    @Column(name = "performer_name", unique = true)
    private String performerName;

    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    Set<PerformedComposition> performedCompositions;

    public Performer(long id, String performerName) {
        this.id = id;
        this.performerName = performerName;
    }

    public Performer(String performerName) {
        this.performerName = performerName;
    }

    public Performer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
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
        return "Performer{" +
                "id=" + id +
                ", performerName='" + performerName + '\'' +
                ", performedCompositions=" + performedCompositions +
                '}';
    }
}
