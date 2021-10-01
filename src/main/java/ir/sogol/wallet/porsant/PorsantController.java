package ir.sogol.wallet.porsant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PorsantController {
    @Autowired
    PorsantManager porsantManager;

    @PostMapping("/porsant")
    public PorsantDTO savePorsant(PorsantDTO dto) throws ValidationException {
        return porsantManager.save(dto);
    }

    @PutMapping("/porsant")
    public PorsantDTO updatePorsant(PorsantDTO dto) throws ValidationException {

        return porsantManager.update(dto);
    }

    @GetMapping("/porsant")
    public List<PorsantDTO> getAll() {
        return porsantManager.findAll();
    }

    @GetMapping("/porsant")
    public Optional<PorsantDTO> getPorsant(Long id) throws ValidationException {
        return porsantManager.findById(id);
    }

    @DeleteMapping("/porsant")
    public void deletePorsant(Long id) throws ValidationException {
        porsantManager.delete(id);
    }
}
