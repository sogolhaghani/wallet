package ir.sogol.wallet.product;

import javax.persistence.*;


@Entity
@Table(name = "interview_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getPrice() {

        return price;
    }

    public void setPrice(Integer price) {

        this.price = price;
    }

    @Override
    public String toString() {

        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
