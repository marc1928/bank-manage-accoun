package materialstech.com.accountsrevice.web;


import materialstech.com.accountsrevice.client.CustomerRestClient;
import materialstech.com.accountsrevice.entities.BankAccount;
import materialstech.com.accountsrevice.model.Customer;
import materialstech.com.accountsrevice.repository.BankAccountRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private final BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/api/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
            account.setCustomer(customer);
        });
        return accountList;
    }
    @GetMapping("/api/accounts/{id}")
    public BankAccount accountById(@PathVariable String id){
         BankAccount bankAccount = accountRepository.findById(id).get();
         Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
         return bankAccount;
    }
}
