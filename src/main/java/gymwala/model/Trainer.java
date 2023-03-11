package gymwala.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @SequenceGenerator(name = "trn_seq", sequenceName = "trainer_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "trn_seq")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "photo")
    private String photo;
    @Column(name = "aadhaar")
    private long aadhaar;
    @Column(name = "phone")
    private long phone;

    public Trainer() {}

    public Trainer(String name, String address, String photo, long aadhaar, long phone) {
        this.name = name;
        this.address = address;
        this.photo = photo;
        this.aadhaar = aadhaar;
        this.phone = phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return getPhone() == trainer.getPhone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhone());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

}
