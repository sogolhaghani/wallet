package ir.sogol.wallet.user;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String username;

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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
