package ir.sogol.wallet.user;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public abstract class UserManager<T extends UserDTO> {
    public abstract T save(T userDTO) throws ValidationException;
    public abstract T update(T userDTO);
    public abstract List<T>  findAll();
    public abstract Optional<T> findById(Long id) throws ValidationException;
    public abstract void delete(Long id) throws ValidationException;

}
