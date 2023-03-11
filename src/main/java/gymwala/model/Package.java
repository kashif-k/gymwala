package gymwala.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "package")
public class Package {

    @Id
    @SequenceGenerator(name = "pak_seq", sequenceName = "package_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pak_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "duration")
    private int duration;

    public Package() {
    }

    public Package(String type, BigDecimal amount, int duration) {
        this.type = type;
        this.amount = amount;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Package{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", duration=" + duration +
                '}';
    }
}
