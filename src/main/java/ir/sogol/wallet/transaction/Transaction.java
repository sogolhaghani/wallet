package ir.sogol.wallet.transaction;

import ir.sogol.wallet.product.Product;
import ir.sogol.wallet.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interview_porsant")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "SELLDATE")
    private Date sellDate;

    @Column(name = "PORSANTVALUE")
    private Double porsantValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER", nullable = false)
    private User seller;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public Double getPorsantValue() {
        return porsantValue;
    }

    public void setPorsantValue(Double porsantValue) {
        this.porsantValue = porsantValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + id +
            ", sellDate=" + sellDate +
            ", porsantValue=" + porsantValue +
            ", product=" + product +
            ", seller=" + seller +
            '}';
    }
}
