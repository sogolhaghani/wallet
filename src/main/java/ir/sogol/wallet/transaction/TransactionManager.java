package ir.sogol.wallet.transaction;


import ir.sogol.wallet.porsant.Porsant;
import ir.sogol.wallet.porsant.PorsantManager;
import ir.sogol.wallet.product.ProductDAO;
import ir.sogol.wallet.user.User;
import ir.sogol.wallet.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class TransactionManager {

    @Autowired
    TransactionDAO transactionDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    PorsantManager porsantManager;

    public TransactionDTO save(TransactionDTO dto) throws ValidationException {
        if(dto.getId() != null)
            throw new ValidationException("Create : id should be null");
        Transaction entity = mapToEntity(dto);
        Transaction newEntity = transactionDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public TransactionDTO update(TransactionDTO dto) throws ValidationException {
        if(dto.getId() == null)
            throw new ValidationException("Update: id should not be null");

        Transaction entity = mapToEntity(dto);

        Transaction newEntity = transactionDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public List<TransactionDTO> findAll() {
        List<Transaction> list = transactionDAO.findAll();
        return list.stream().map(x-> mapToDTO(x)).collect(Collectors.toList());
    }

    public Optional<TransactionDTO> findById(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("load: id should not be null");
        Optional<Transaction> entity = transactionDAO.findById(id);
        if(entity.isEmpty())
            return Optional.empty();
        return Optional.of(mapToDTO(entity.get()));
    }


    public void delete(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("delete: id should not be null");
        transactionDAO.deleteById(id);
    }

    private Transaction mapToEntity(TransactionDTO dto){
        Transaction entity =  new Transaction();
        entity.setId(dto.getId());
        entity.setProduct(productDAO.getById(dto.getProductId()));
        entity.setSeller((User) userDAO.getById(dto.getSellerId()));
        entity.setSellDate(dto.getSellDate() == null ? new Date() : dto.getSellDate());
        Optional<Porsant> porsant = porsantManager.findByResellerActiveInDate(entity.getSeller().getId(), entity.getSellDate());
        if(porsant.isPresent()) {
            Double price = porsant.get().getPersent() * entity.getProduct().getPrice();
            entity.setPorsantValue(price);
        }
        return entity;
    }

    private TransactionDTO mapToDTO(Transaction entity) {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(entity.getId());
        dto.setPorsantValue(entity.getPorsantValue());
        dto.setSellDate(entity.getSellDate());
        dto.setProductId(entity.getProduct().getId());
        dto.setProductName(entity.getProduct().getName());
        dto.setSellerId(entity.getSeller().getId());
        dto.setSellerName(entity.getSeller().getName());
        return dto;
    }
}
