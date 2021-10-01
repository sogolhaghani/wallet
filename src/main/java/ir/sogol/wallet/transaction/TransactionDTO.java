package ir.sogol.wallet.transaction;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class TransactionDTO implements Serializable {
    private Long id;
    private Date sellDate;
    private Double porsantValue;
    private Long productId;
    private String productName;
    private Long sellerId;
    private String sellerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @NotNull
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @NotNull
    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
