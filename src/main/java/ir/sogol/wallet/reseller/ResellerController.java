package ir.sogol.wallet.reseller;

import ir.sogol.wallet.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResellerController extends UserController<ResellerDTO> {

    @Autowired ResellerManager resellerManager;

    @Override
    @PostMapping("/reseller")
    public ResellerDTO saveUser(ResellerDTO userDTO) {
        return resellerManager.save(userDTO);
    }

    @Override
    @PutMapping("/reseller")
    public ResellerDTO updateUser(ResellerDTO userDTO) {
        return resellerManager.update(userDTO);
    }

    @Override
    @GetMapping("/reseller")
    public List<ResellerDTO> getAll() {
        return resellerManager.findAll();
    }

    @Override
    @GetMapping("/reseller")
    public Optional<ResellerDTO> getUser(Long id) {
        return resellerManager.findById(id);
    }

    @Override
    @DeleteMapping("/reseller")
    public void deleteUser(Long id) {
        resellerManager.delete(id);
    }
}
