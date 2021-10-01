package ir.sogol.wallet.employee;

import ir.sogol.wallet.user.UserDTO;

import javax.validation.constraints.NotNull;

public class EmployeeDTO extends UserDTO {
    private String position;

    @NotNull
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
