package doemu.buildingweb.Views;

import com.sun.istack.NotNull;

public class PerformedCompositionsViewModel {

    private long id;
    @NotNull
    private String performerName;
    @NotNull
    private String compositionName;

    /*public PerformedCompositionsViewModel(String performerName, String compositionName) {
        this.performerName = performerName;
        this.compositionName = compositionName;
    }*/

    public PerformedCompositionsViewModel() {}

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getCompositionName() {
        return compositionName;
    }

    public void setCompositionName(String compositionName) {
        this.compositionName = compositionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

