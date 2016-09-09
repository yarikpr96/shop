package Class.Entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity
public class Ordering {
    @Id
    @GeneratedValue
    @Column
    private int id_o;
    @Column
    private double sum;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "purse_ordering",joinColumns = @JoinColumn(name = "id_o"),inverseJoinColumns = @JoinColumn(name = "id_p"))
    private List<Purse>purseList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;


    public Ordering() {
        this.date = Calendar.getInstance().getTime();
    }

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Purse> getPurseList() {
        return purseList;
    }

    public void setPurseList(List<Purse> purseList) {
        this.purseList = purseList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Ordering{" +
                "sum " + sum +
                ", date= " + date +
                ", customer " + customer +
                '}';
    }
}
