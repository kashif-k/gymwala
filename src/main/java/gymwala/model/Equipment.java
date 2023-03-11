package gymwala.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @SequenceGenerator(name = "eqp_seq", sequenceName = "equipment_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "eqp_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private int quantity;

    public Equipment() {}

    public Equipment(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return getId() == equipment.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
