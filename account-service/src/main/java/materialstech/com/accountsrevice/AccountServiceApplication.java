package materialstech.com.accountsrevice;

import materialstech.com.accountsrevice.client.CustomerRestClient;
import materialstech.com.accountsrevice.entities.BankAccount;
import materialstech.com.accountsrevice.enums.AccounType;
import materialstech.com.accountsrevice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.util.UUID;

@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.allCustomers().forEach(c -> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("EURO")
                        .balance(Math.random() * 1000)
                        .createAt(LocalDate.now())
                        .updateAt(LocalDate.now())
                        .type(AccounType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("EURO")
                        .balance(Math.random() * 1000)
                        .createAt(LocalDate.now())
                        .updateAt(LocalDate.now())
                        .type(AccounType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                accountRepository.save(bankAccount1);
                accountRepository.save(bankAccount2);
            });

        };
    }
}
