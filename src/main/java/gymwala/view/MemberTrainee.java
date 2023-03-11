package gymwala.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.sql.Date;

@Entity
@Immutable
@Table(name = "memtrainee")
public class MemberTrainee {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "tname")
    private String trainerName;
    @Column(name = "month")
    private int month;
    @Column(name = "sdate")
    private Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getMonth() {
        return month;
    }

    public Date getDate() {
        return date;
    }
}
