package Class.Entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_c;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String password;
    @Transient
    private String passwordConfirm;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
    private List<Ordering>orderingList;

    public Customer() {
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public String toString() {
        return "Customer|" +
                 name + " " +
                 surname + " " +
                ", phone " + phone + " " +
                ", email " + email + " " +

                '|';
    }
}
