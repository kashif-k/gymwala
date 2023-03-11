package gymwala.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "member")
public class Member{

    @Id
    @SequenceGenerator(name = "mem_seq", sequenceName = "member_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mem_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "photo")
    private String photo;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "weight")
    private String weight;
    @Column(name = "height")
    private String height;
    @Column(name = "aadhaar")
    private long aadhaar;
    @Column(name = "phone")
    private long phone;
    @Column(name = "doj")
    private Date doj;

    public Member() {}

    public Member(String name, String address, String photo, Date dob, String weight, String height, long aadhaar, long phone, Date doj) {
        this.name = name;
        this.address = address;
        this.photo = photo;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.aadhaar = aadhaar;
        this.phone = phone;
        this.doj = doj;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public long getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(long aadhaar) {
        this.aadhaar = aadhaar;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getPhone() == member.getPhone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhone());
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", doj=" + doj +
                '}';
    }
}