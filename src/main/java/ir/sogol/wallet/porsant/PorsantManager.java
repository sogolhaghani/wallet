package ir.sogol.wallet.porsant;

import ir.sogol.wallet.reseller.Reseller;
import ir.sogol.wallet.reseller.ResellerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
@Service
public class PorsantManager {

    @Autowired
    PorsantDAO porsantDAO;
    @Autowired
    ResellerDAO resellerDAO;

    public PorsantDTO save(PorsantDTO dto) throws ValidationException {
        if(dto.getId() != null)
            throw new ValidationException("Create : id should be null");
        Porsant entity = mapToEntity(dto);
        Porsant newEntity = porsantDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public PorsantDTO update(PorsantDTO dto) throws ValidationException {
        if(dto.getId() == null)
            throw new ValidationException("Update: id should not be null");
        Porsant oldEntity = porsantDAO.getById(dto.getId());
        Porsant entity = mapToEntity(dto);
        if(oldEntity.getReseller().getId() != entity.getId())
            throw new ValidationException("reseller id");
        Porsant newEntity = porsantDAO.save(entity);
        return mapToDTO(newEntity);
    }

    public List<PorsantDTO> findAll() {
        List<Porsant> list = porsantDAO.findAll();
        return list.stream().map(x-> mapToDTO(x)).collect(Collectors.toList());
    }

    public Optional<PorsantDTO> findById(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("load: id should not be null");
        Optional<Porsant> entity = porsantDAO.findById(id);
        if(entity.isEmpty())
            return Optional.empty();
        return Optional.of(mapToDTO(entity.get()));
    }


    public void delete(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("delete: id should not be null");
        porsantDAO.deleteById(id);
    }

    private Porsant mapToEntity(PorsantDTO dto){
        Porsant entity =  new Porsant();

        entity.setFromDate(dto.getFromDate() == null ? new Date() : dto.getFromDate());
        entity.setReseller(resellerDAO.findById(dto.getResellerId()).get());
        entity.setPersent(dto.getPersent());
        return entity;
    }

    private PorsantDTO mapToDTO(Porsant entity) {
        PorsantDTO dto = new PorsantDTO();
        dto.setId(entity.getId());
        dto.setPersent(entity.getPersent());
        dto.setFromDate(entity.getFromDate());
        return dto;
    }
    @PersistenceContext
    EntityManager entityManager;

    public Optional<Porsant> findByResellerActiveInDate(long resellerId, Date activefrom) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Porsant> query = cb.createQuery(Porsant.class);
        Root<Porsant> root = query.from(Porsant.class);

        List<Predicate> predicates = new ArrayList<>();
        Join<Porsant, Reseller> joinOnStudent = root.join("reseller");
        predicates.add(cb.greaterThanOrEqualTo(root.get("activefrom"), activefrom));
        predicates.add(cb.equal(joinOnStudent.get("id"), resellerId));
        CriteriaQuery<Porsant> criteriaQuery = query.select(root).where(predicates.toArray(new Predicate[]{})).orderBy(cb.asc(root.get("activefrom")));
        Query limitedCriteriaQuery = entityManager.createQuery(criteriaQuery)
            .setMaxResults(1); // this is the important part
        List list = limitedCriteriaQuery.getResultList();
        if(list == null || list.isEmpty())
            return Optional.empty();
        return (Optional<Porsant>) list.get(0);

    }
}
