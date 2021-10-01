package ir.sogol.wallet.porsant;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class PorsantDTO implements Serializable {

    private Long id;
    private Double persent;
    private Long resellerId;
    private Date fromDate;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public Double getPersent() {
        return persent;
    }

    public void setPersent(Double persent) {
        this.persent = persent;
    }
    @NotNull
    public Long getResellerId() {
        return resellerId;
    }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }
}
