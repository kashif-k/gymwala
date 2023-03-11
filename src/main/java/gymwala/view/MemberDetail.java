package gymwala.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Immutable
@Table(name = "memdetail")
public class MemberDetail {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private long phone;
    @Column(name = "package_type")
    private String packageType;
    @Column(name = "month")
    private int month;
    @Column(name = "mdate")
    private Date packageDate;
    @Column(name = "tname")
    private String trainerName;
    @Column(name = "tdate")
    private Date trainerDate;
    @Column(name = "bal")
    private BigDecimal balance;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getPackageType() {
        return packageType;
    }

    public int getMonth() {
        return month;
    }

    public Date getPackageDate() {
        return packageDate;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public Date getTrainerDate() {
        return trainerDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
