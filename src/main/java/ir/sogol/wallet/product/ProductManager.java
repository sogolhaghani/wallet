package ir.sogol.wallet.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class ProductManager {

    @Autowired
    ProductDAO productDAO;

    public ProductDTO save(ProductDTO dto) throws ValidationException {
        if(dto.getId() != null)
            throw new ValidationException("Create : id should be null");
        Product entity = mapToEntity(dto);
        Product newEntity = productDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public ProductDTO update(ProductDTO dto) throws ValidationException {
        if(dto.getId() == null)
            throw new ValidationException("Update: id should not be null");

        Product entity = mapToEntity(dto);

        Product newEntity = productDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public List<ProductDTO> findAll() {
        List<Product> list = productDAO.findAll();
        return list.stream().map(x-> mapToDTO(x)).collect(Collectors.toList());
    }

    public Optional<ProductDTO> findById(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("load: id should not be null");
        Optional<Product> entity = productDAO.findById(id);
        if(entity.isEmpty())
            return Optional.empty();
        return Optional.of(mapToDTO(entity.get()));
    }


    public void delete(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("delete: id should not be null");
        productDAO.deleteById(id);
    }

    private Product mapToEntity(ProductDTO dto){
        Product entity =  new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    private ProductDTO mapToDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
