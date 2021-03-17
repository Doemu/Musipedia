package doemu.buildingweb.Views;

import com.sun.istack.NotNull;

public class CompositionViewModel {
    @NotNull
    private String name;

    public CompositionViewModel(String name) {
        this.name = name;
    }

    public CompositionViewModel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
