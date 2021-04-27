package fr.alternalis.banks.controllers.rest;

import fr.alternalis.banks.controllers.rest.xml.request.TransactionRequestXml;
import fr.alternalis.banks.controllers.rest.xml.response.ResponseXml;
import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.iservices.IOperationService;
import fr.alternalis.banks.iservices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for the XML rest service.
 */
@RestController
@RequestMapping("/rest/xml/user")
public class BanksXmlRestController {

    private final IOperationService operationService;

    private final IUserService userService;

    @Autowired
    public BanksXmlRestController(IOperationService operationService, IUserService userService){
        this.operationService = operationService;
        this.userService = userService;
    }

    /**
     * Function that effectuate an operation for an account.
     * @param request contain the username of the needed account and the value of the transaction.
     * @return A ResponseEntity that contain an error, or the information that the operation has been made.
     */
    @PostMapping(value="/transaction", consumes="application/xml", produces="application/xml")
    public ResponseEntity<?> makeUserTransaction(@RequestBody TransactionRequestXml request){
        UserDTO user = userService.getUserByUsername(request.getUsername());
        Double value;
        if(user == null){
            return new ResponseEntity<>(new ResponseXml(1, "No user found"), HttpStatus.OK);
        } else {
            try{
                value = Double.parseDouble(request.getValue());
            } catch (NumberFormatException e){
                return new ResponseEntity<>(new ResponseXml(2,"Incorrect value"), HttpStatus.OK);
            }
            userService.updateUserBalance(user.getUsername(), value);
            operationService.saveOperationForUser(user, value);
            return new ResponseEntity<>(new ResponseXml(0, "User correctly updated"), HttpStatus.OK);
        }
    }
}
