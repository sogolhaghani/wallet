package ir.sogol.wallet.product;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProductDTO implements Serializable {
    private Long id;
    private String name;
    private Integer price;

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
