package ir.sogol.wallet.employee;

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
public class EmployeeManager extends UserManager<EmployeeDTO> {

    @Autowired EmployeeDAO employeeDAO;

    @Override
    public EmployeeDTO save(EmployeeDTO dto) throws ValidationException {
        Employee entity = mapToEntity(dto);
        if(employeeDAO.findByUserName(entity.getUsername()).isPresent())
            throw new ValidationException("userExist" + entity.getUsername());
        Employee newEntity = employeeDAO.save(entity);
        return mapToDTO(newEntity);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO dto) {
        Employee entity = mapToEntity(dto);
        Employee newEntity = employeeDAO.save(entity);
        return mapToDTO(newEntity);
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> list = employeeDAO.findAll();
        return list.stream().map(x-> mapToDTO(x)).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> findById(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("delete: id should not be null");
        Optional<Employee> entity = employeeDAO.findById(id);
        if(entity.isEmpty())
            return Optional.empty();
        return Optional.of(mapToDTO(entity.get()));
    }

    @Override
    public void delete(Long id) throws ValidationException {
        if(id == null)
            throw new ValidationException("delete: id should not be null");
        employeeDAO.deleteById(id);
    }

    private Employee mapToEntity(EmployeeDTO dto){
        Employee entity =  new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUsername(dto.getUsername());
        entity.setPosition(dto.getPosition());
        return entity;
    }

    private EmployeeDTO mapToDTO(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setPosition(entity.getPosition());
        dto.setUsername(entity.getUsername());
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
