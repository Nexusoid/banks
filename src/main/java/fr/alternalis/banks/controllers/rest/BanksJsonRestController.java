package fr.alternalis.banks.controllers.rest;

import fr.alternalis.banks.controllers.rest.json.request.BalanceRequestJson;
import fr.alternalis.banks.controllers.rest.json.request.OperationsRequestJson;
import fr.alternalis.banks.controllers.rest.json.response.BalanceResponseJson;
import fr.alternalis.banks.controllers.rest.json.response.ErrorResponseJson;
import fr.alternalis.banks.controllers.rest.json.response.OperationsResponseJson;
import fr.alternalis.banks.dtos.OperationDTO;
import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.iservices.IOperationService;
import fr.alternalis.banks.iservices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/json/user")
public class BanksJsonRestController {

    private final IOperationService operationService;

    private final IUserService userService;

    @Autowired
    public BanksJsonRestController(IOperationService operationService, IUserService userService){
        this.operationService = operationService;
        this.userService = userService;
    }

    @GetMapping(value = "/balance", consumes="application/json", produces = "application/json")
    public ResponseEntity<?> getUserAmount(@RequestBody BalanceRequestJson request){
        UserDTO user = userService.getUserByUsername(request.getUsername());
        if(user == null){
            return new ResponseEntity<>(new ErrorResponseJson("No user found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new BalanceResponseJson(user.getBalance()), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/operations", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getUserOperations(@RequestBody OperationsRequestJson request){
        int numberOps;
        try{
            numberOps = Integer.parseInt(request.getNumber());
        } catch (NumberFormatException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDTO user = userService.getUserByUsername(request.getUsername());
        if(user != null) {
            List<OperationDTO> operations = operationService.getLastOperations(numberOps, user);
            if (operations != null && !operations.isEmpty()) {
                return new ResponseEntity<>(new OperationsResponseJson(operations), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new ErrorResponseJson("No operation found"), HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new ErrorResponseJson("No user found"), HttpStatus.NOT_FOUND);
        }
    }
}
