package doemu.buildingweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "performer", schema = "public")
public class Performer {
    @Column(name = "performer_name")
    @Id
    private String performerName;

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
