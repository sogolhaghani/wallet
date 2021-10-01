package ir.sogol.wallet.porsant;

import ir.sogol.wallet.reseller.Reseller;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interview_porsant")
public class Porsant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "PERSENT", nullable = false)
    private Double persent;

    @Column(name = "FROMDATE", nullable = false, unique = true)
    private Date fromDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESELLER", nullable = false)
    private Reseller reseller;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPersent() {
        return persent;
    }

    public void setPersent(Double persent) {
        this.persent = persent;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    @Override
    public String toString() {
        return "Porsant{" +
            "id=" + id +
            ", persent=" + persent +
            ", fromDate=" + fromDate +
            ", reseller=" + reseller +
            '}';
    }
}
