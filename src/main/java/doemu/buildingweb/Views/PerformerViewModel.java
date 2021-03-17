package doemu.buildingweb.Views;

import com.sun.istack.NotNull;

public class PerformerViewModel {
    @NotNull
    private String name;

    public PerformerViewModel(String name) {
        this.name = name;
    }

    public PerformerViewModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
