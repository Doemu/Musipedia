package doemu.buildingweb.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "performer", schema = "public")
public class Performer {
    @Column(name = "performer_name")
    @Id
    private String performerName;
    @OneToMany(mappedBy = "performer", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PerformedComposition> performedCompositions;

    public Performer(String performerName) {
        this.performerName = performerName;
    }
    public Performer(){}

    @Override
    public String toString() {
        return "Performer{" +
                "performerName='" + performerName + '\'' +
                '}';
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }
}
