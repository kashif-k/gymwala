package gymwala.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @SequenceGenerator(name = "pay_seq", sequenceName = "payment_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "pay_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "date")
    private Date date;

    public Payment() {}

    public Payment(int memberId, BigDecimal amount, Date date) {
        this.memberId = memberId;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return getId() == payment.getId() && getMemberId() == payment.getMemberId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId());
    }
}
