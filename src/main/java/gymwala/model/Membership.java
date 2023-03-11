package gymwala.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "membership")
public class Membership {

    @Id
    @SequenceGenerator(name = "mship_seq", sequenceName = "membership_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mship_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "package_id")
    private int packageId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "payment_id")
    private int paymentId;

    public Membership() {}

    public Membership(int memberId, int packageId, Date startDate, int paymentId) {
        this.memberId = memberId;
        this.packageId = packageId;
        this.startDate = startDate;
        this.paymentId = paymentId;
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

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "memberId=" + memberId +
                ", packageId=" + packageId +
                ", startDate=" + startDate +
                ", paymentId=" + paymentId +
                '}';
    }
}
