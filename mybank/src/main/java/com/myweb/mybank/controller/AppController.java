package com.myweb.mybank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.mybank.model.entities.Transactions;
import com.myweb.mybank.model.entities.User;
import com.myweb.mybank.model.repositories.TransactionRepository;
import com.myweb.mybank.model.repositories.UserRepository;
import com.myweb.mybank.model.services.UsersService;


@RestController
@CrossOrigin(origins = "http://localhost:5500")
public class AppController {
    // @Autowired
    // private UserRepository repo;
    @Autowired
    private TransactionRepository trepo;
    @Autowired
    private UsersService usersService;
    // @GetMapping("/")
    // public String viewHomePage() {
    //     return "index";
    // }
    // @GetMapping("/register")
    // public String showSignUpForm(Model model) {
    //     model.addAttribute("user", new User());
    //     return "signup_form";
    // }
    
    @PostMapping("/process_register")
    public String getInformation(@RequestBody User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        usersService.createUser(user);
        usersService.loadUserByUsername(user.getEmail());
        return "success";
    }
    @GetMapping("/transfer")
    public String showTransferForm(Model model, User user) {
        Transactions transaction = new Transactions();
        model.addAttribute("transaction", transaction);
        return "transfer_form";
    }
    @PostMapping("/process_transfer")
    public String getTransferInformation(Transactions transaction) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        transaction.setDate(formatter.format(date));
        transaction.setTransactionType("Send money");
        trepo.save(transaction);
        return "success_transfer";
    }
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Transactions> listUsers = trepo.findAll(Sort.by(Sort.Direction.DESC, "date"));
        model.addAttribute("transactions", listUsers);
        return "users_table";
    }
}
