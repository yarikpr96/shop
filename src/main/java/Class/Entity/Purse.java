package Class.Entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Purse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_p;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    @Lob
    private byte image [] = new byte[1];

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "purse_ordering",joinColumns = @JoinColumn(name = "id_p"),inverseJoinColumns = @JoinColumn(name = "id_o"))
    private List<Ordering>orderingList;

    public Purse() {
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Ordering> getOrderingList() {
        return orderingList;
    }

    public void setOrderingList(List<Ordering> orderingList) {
        this.orderingList = orderingList;
    }

    @Override
    public String toString() {
        return "Purse|" +
                "N" + id_p +
                ", name " + name + '\'' +
                ", price " + price +

                '|';
    }
}
