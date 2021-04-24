package fr.alternalis.banks.controllers.web;

import fr.alternalis.banks.controllers.web.form.UserForm;
import fr.alternalis.banks.dtos.OperationDTO;
import fr.alternalis.banks.dtos.UserDTO;
import fr.alternalis.banks.iservices.IOperationService;
import fr.alternalis.banks.iservices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BanksWebController {

    private IUserService userService;

    private IOperationService operationService;

    @Autowired
    public BanksWebController(IUserService userService, IOperationService operationService){
        this.userService = userService;
        this.operationService = operationService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("form", new UserForm());
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("form", new UserForm());
        return "register";
    }

    @PostMapping("/myaccount")
    public String myaccount(@ModelAttribute UserForm form, Model model) {
        UserDTO user = userService.getUserByUsername(form.getUsername());
        if(user != null){
            if(form.getPassword().equals(user.getPassword())){
                List<OperationDTO> operationsDTO = operationService.getLastOperations(10, user);
                model.addAttribute("user", user);
                if(operationsDTO != null && !operationsDTO.isEmpty()){
                    model.addAttribute("operations", operationsDTO);
                }
            }
        }
        return "myaccount";
    }

    @PostMapping("/complete")
    public String complete(@ModelAttribute UserForm form, Model model){
        userService.registerUser(form.getUsername(), form.getPassword());
        return "complete";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
