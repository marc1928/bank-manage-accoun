package materialstech.com.accountsrevice;

import materialstech.com.accountsrevice.entities.BankAccount;
import materialstech.com.accountsrevice.enums.AccounType;
import materialstech.com.accountsrevice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository) {
        return args -> {
            BankAccount bankAccount1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("EURO")
                    .balance(1000.00)
                    .createAt(LocalDate.now())
                    .updateAt(LocalDate.now())
                    .customerId(Long.valueOf(1))
                    .type(AccounType.CURRENT_ACCOUNT)
                    .build();
            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("EURO")
                    .balance(1002.00)
                    .createAt(LocalDate.now())
                    .updateAt(LocalDate.now())
                    .customerId(Long.valueOf(2))
                    .type(AccounType.CURRENT_ACCOUNT)
                    .build();
            accountRepository.save(bankAccount1);
            accountRepository.save(bankAccount2);
        };
    }
}
