package ir.sogol.wallet.employee;

import ir.sogol.wallet.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController extends UserController<EmployeeDTO> {

    @Autowired EmployeeManager employeeManager;

    @Override
    @PostMapping("/employee")
    public EmployeeDTO saveUser(EmployeeDTO dto) {
        return employeeManager.save(dto);
    }

    @Override
    @PutMapping("/employee")
    public EmployeeDTO updateUser(EmployeeDTO dto) {

        return employeeManager.update(dto);
    }

    @Override
    @GetMapping("/employee")
    public List<EmployeeDTO> getAll() {
        return employeeManager.findAll();
    }

    @Override
    public Optional<EmployeeDTO> getUser(Long id) throws ValidationException {
        return employeeManager.findById(id);
    }

    @Override
    @DeleteMapping("/employee")
    public void deleteUser(Long id) throws ValidationException {
        employeeManager.delete(id);
    }
}
