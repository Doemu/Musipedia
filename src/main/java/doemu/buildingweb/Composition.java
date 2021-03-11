package doemu.buildingweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Composition")
public class Composition {
    @Column(name = "compositionName")
    private String compositionName;
}
