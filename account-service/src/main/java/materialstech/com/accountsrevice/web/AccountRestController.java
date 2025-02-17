package materialstech.com.accountsrevice.web;


import materialstech.com.accountsrevice.entities.BankAccount;
import materialstech.com.accountsrevice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;

    public AccountRestController(BankAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/api/accounts")
    public List<BankAccount> accountList(){
        return accountRepository.findAll();
    }
    @GetMapping("/api/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
        return accountRepository.findById(id).get();
    }
}
