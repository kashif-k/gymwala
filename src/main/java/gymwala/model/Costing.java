package gymwala.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "costing")
public class Costing {

    @Id
    @SequenceGenerator(name = "cost_seq", sequenceName = "costing_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cost_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "date")
    private Date date;

    public Costing() {}

    public Costing(String title, BigDecimal amount, Date date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Costing{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
