package mainApp.repositories;

import mainApp.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    Account withdraw(Long id, Double amountToWithdraw);
}
