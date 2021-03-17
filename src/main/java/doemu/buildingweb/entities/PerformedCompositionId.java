package doemu.buildingweb.entities;

import java.io.Serializable;
import java.util.Objects;

public class PerformedCompositionId implements Serializable {
    private String compositionName;
    private String performerName;

    public PerformedCompositionId(){}

    public PerformedCompositionId(String compositionName, String performerName) {
        this.compositionName = compositionName;
        this.performerName = performerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformedCompositionId that = (PerformedCompositionId) o;
        return compositionName.equals(that.compositionName) && performerName.equals(that.performerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compositionName, performerName);
    }
}
