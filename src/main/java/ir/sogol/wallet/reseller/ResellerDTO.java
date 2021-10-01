package ir.sogol.wallet.reseller;

import ir.sogol.wallet.user.UserDTO;

import javax.validation.constraints.NotNull;

public class ResellerDTO extends UserDTO {

    private String code;

    @NotNull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
