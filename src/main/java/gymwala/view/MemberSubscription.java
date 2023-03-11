package gymwala.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.sql.Date;

@Entity
@Immutable
@Table(name = "memsubscription")
public class MemberSubscription {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private long phone;
    @Column(name = "subscription")
    private String subscription;
    @Column(name = "months")
    private int months;
    @Column(name = "sdate")
    private Date date;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getSubscription() {
        return subscription;
    }

    public int getMonths() {
        return months;
    }

    public Date getDate() {
        return date;
    }
}
