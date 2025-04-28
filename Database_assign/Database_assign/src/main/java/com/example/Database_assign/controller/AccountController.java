package com.example.Database_assign.controller;


import com.example.Database_assign.entities.Account;
import com.example.Database_assign.entities.Admin;
import com.example.Database_assign.entities.Customer;
import com.example.Database_assign.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String SelectRegistration(){
        return "SelectRegistration";
    }

//    @GetMapping("/register")
//    public String RegisterForm(Model model){
//        Account n = new Account();
//        model.addAttribute("account", n);
//        System.out.println(n.getAccount_id());
//        return "RegisterPage";
//    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("account") Account account){
        System.out.println(account.getAccount_id());
        accountService.addAccount(account);

        return "Register_succeeded";
    }

    @GetMapping("/admin-registration")
    public String adminRegistration(Model model){
        Admin ad = new Admin();
        model.addAttribute("account", ad);
        return "AdminRegistration";
    }

    @GetMapping("/customer-registration")
    public String customerRegistration(Model model){
        Customer cus = new Customer();
        model.addAttribute("account", cus);
        return "CustomerRegistration";
    }

    @PostMapping("/process_admin")
    public String processAdmin(@ModelAttribute("account") Admin ad){
        accountService.addAccount(ad);

        return "Register_succeeded";
    }

    @PostMapping("/process_customer")
    public String processCustomer(@ModelAttribute("account") Customer cus){
        
        return "Register_succeeded";
    }
}
