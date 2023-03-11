package gymwala.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "traineeship")
public class Traineeship {

    @Id
    @SequenceGenerator(name = "tship_seq", sequenceName = "traineeship_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "tship_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "trainer_id")
    private int trainerId;
    @Column(name = "month")
    private int month;
    @Column(name = "start_date")
    private Date startDate;

    public Traineeship() {}

    public Traineeship(int memberId, int trainerId, int month, Date startDate) {
        this.memberId = memberId;
        this.trainerId = trainerId;
        this.month = month;
        this.startDate = startDate;
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

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Traineeship{" +
                "memberId=" + memberId +
                ", trainerId=" + trainerId +
                ", month=" + month +
                ", startDate=" + startDate +
                '}';
    }
}
