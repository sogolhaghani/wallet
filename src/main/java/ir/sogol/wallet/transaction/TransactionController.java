package ir.sogol.wallet.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionManager transactionManager;

    @PostMapping("/transaction")
    public TransactionDTO saveTransaction(TransactionDTO dto) throws ValidationException {
        return transactionManager.save(dto);
    }

    @PutMapping("/transaction")
    public TransactionDTO updateTransaction(TransactionDTO dto) throws ValidationException {
        return transactionManager.update(dto);
    }

    @GetMapping("/transaction")
    public List<TransactionDTO> getAll() {
        return transactionManager.findAll();
    }

    @GetMapping("/transaction")
    public Optional<TransactionDTO> getTransaction(Long id) throws ValidationException {
        return transactionManager.findById(id);
    }

    @DeleteMapping("/transaction")
    public void deleteTransaction(Long id) throws ValidationException {
        transactionManager.delete(id);
    }
}
