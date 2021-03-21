package doemu.buildingweb.Views;

import com.sun.istack.NotNull;

public class PerformerViewModel {

    private long id;
    @NotNull
    private String name;

    public PerformerViewModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PerformerViewModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
