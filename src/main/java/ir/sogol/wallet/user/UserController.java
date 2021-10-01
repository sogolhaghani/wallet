package ir.sogol.wallet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public abstract class UserController<T extends UserDTO> {
    @Autowired UserManager userManager;

    public abstract T saveUser(@Validated @RequestBody T userDTO) ;
    public abstract T updateUser(@Validated @RequestBody T userDTO) ;
    public abstract List<T> getAll() ;
    public abstract Optional<T> getUser(@PathVariable Long id) throws ValidationException;
    public abstract void deleteUser(@PathVariable Long id) throws ValidationException;

}
