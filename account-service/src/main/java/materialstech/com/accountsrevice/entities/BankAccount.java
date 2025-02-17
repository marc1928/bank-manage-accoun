package materialstech.com.accountsrevice.entities;

import jakarta.persistence.*;
import lombok.*;
import materialstech.com.accountsrevice.enums.AccounType;
import materialstech.com.accountsrevice.model.Customer;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private Double balance;
    private LocalDate createAt;
    private LocalDate updateAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccounType type;

    @Transient
    private Customer customer;
    private Long customerId;
}
