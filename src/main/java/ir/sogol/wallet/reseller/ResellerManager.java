package ir.sogol.wallet.reseller;

import ir.sogol.wallet.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Transactional
public class ResellerManager extends UserManager<ResellerDTO> {

    @Autowired ResellerDAO resellerDAO;

    @Override
    public ResellerDTO save(ResellerDTO userDTO) throws ValidationException {
        Reseller reseller =  mapToEntity(userDTO);
        if(resellerDAO.findByUserName(reseller.getUsername()).isPresent())
            throw new ValidationException("userExist" + reseller.getUsername());
        Reseller save = resellerDAO.save(reseller);
        return mapToDTO(save);
    }



    @Override
    public ResellerDTO update(ResellerDTO userDTO) {
        Reseller reseller =  mapToEntity(userDTO);
        Reseller save = resellerDAO.save(reseller);
        return mapToDTO(save);
    }

    @Override
    public List<ResellerDTO> findAll() {
        List<Reseller> list = resellerDAO.findAll();
        return list.stream().map(x-> mapToDTO(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<ResellerDTO> findById(Long id) {
        Optional<Reseller> entity = resellerDAO.findById(id);
        if(entity.isEmpty())
            return Optional.empty();
        return Optional.of(mapToDTO(entity.get()));
    }

    @Override
    public void delete(Long id) {
        resellerDAO.deleteById(id);
    }

    private Reseller mapToEntity(ResellerDTO dto){
        Reseller entity =  new Reseller();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setCode(dto.getCode());
        return entity;
    }

    private ResellerDTO mapToDTO(Reseller entity) {
        ResellerDTO dto = new ResellerDTO();
        dto.setCode(entity.getCode());
        dto.setUsername(entity.getUsername());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
