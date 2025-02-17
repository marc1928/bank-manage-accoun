package materialstech.com.accountsrevice.repository;

import materialstech.com.accountsrevice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
