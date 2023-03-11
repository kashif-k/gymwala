package gymwala.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @SequenceGenerator(name = "bal_seq", sequenceName = "balance_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "bal_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "balance")
    private BigDecimal amount;

    public Balance() {}

    public Balance(int memberId, BigDecimal amount) {
        this.memberId = memberId;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "Balance{" +
                "memberId=" + memberId +
                ", amount=" + amount +
                '}';
    }
}
