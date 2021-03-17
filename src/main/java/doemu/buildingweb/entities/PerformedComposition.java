package doemu.buildingweb.entities;

import javax.persistence.*;

@Entity
@Table(name = "performedcomposition", schema = "public")
@IdClass(PerformedCompositionId.class)
public class PerformedComposition {



        @Id
        private String compositionName;
        @Id
        private String performerName;

        public PerformedComposition(String compositionName, String performerName) {
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
        public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    @Override
    public String toString() {
        return "PerformedComposition{" +
                "compositionName='" + compositionName + '\'' +
                ", performerName='" + performerName + '\'' +
                '}';
    }
}
