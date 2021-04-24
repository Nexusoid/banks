package fr.alternalis.banks.services;

import fr.alternalis.banks.dtos.OperationDTO;
import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.entities.Operation;
import fr.alternalis.banks.entities.User;
import fr.alternalis.banks.enums.OperationType;
import fr.alternalis.banks.iservices.IOperationService;
import fr.alternalis.banks.repositories.IOperationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OperationService implements IOperationService {

    private final IOperationRepository operationRepository;

    @Autowired
    public OperationService(IOperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }

    @Override
    public List<OperationDTO> getLastOperations(int number, UserDTO user) {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<OperationDTO, Operation>() {
            @Override
            protected void configure() {
                skip(destination.getUser());
            }
        });
        List<Operation> operationsEntity = operationRepository.getLastOperations(number, mapper.map(user, User.class));
        List<OperationDTO> operationsResult = new ArrayList<>();
        if(operationsEntity != null && !operationsEntity.isEmpty()){
            for(Operation operation : operationsEntity){
                operationsResult.add(mapper.map(operation, OperationDTO.class));
            }
        }
        return operationsResult;
    }

    @Override
    public void saveOperationForUser(UserDTO user, Double value) {
        Operation operation = new Operation();
        ModelMapper mapper = new ModelMapper();
        operation.setUser(mapper.map(user, User.class));
        operation.setValue(value);
        operation.setDate(LocalDate.now());
        if(Math.signum(value) == 1.0){
            operation.setType(OperationType.CREDIT);
        } else {
            operation.setType(OperationType.DEBIT);
        }
        operationRepository.save(operation);
    }
}
