package ir.sogol.wallet.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductManager productManager;

    @PostMapping("/product")
    public ProductDTO saveProduct(ProductDTO dto) throws ValidationException {
        return productManager.save(dto);
    }

    @PutMapping("/product")
    public ProductDTO updateProduct(ProductDTO dto) throws ValidationException {
        return productManager.update(dto);
    }

    @GetMapping("/product")
    public List<ProductDTO> getAll() {
        return productManager.findAll();
    }

    @GetMapping("/product")
    public Optional<ProductDTO> getProduct(Long id) throws ValidationException {
        return productManager.findById(id);
    }

    @DeleteMapping("/product")
    public void deleteProduct(Long id) throws ValidationException {
        productManager.delete(id);
    }
}
