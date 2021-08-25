package mainApp.services;

import mainApp.entities.Account;
import mainApp.entities.AppUser;
import mainApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account read(Long id){
        return accountRepository.findOne(id);
    }

    public List<Account> readAll() {
        Iterable<Account> accountIterable = accountRepository.findAll();
        List<Account> result = new ArrayList<>();
        accountIterable.forEach(result::add);
        return result;
    }

    public Account update(Long id,Account newAccountData){
        Account originalAccount = accountRepository.findOne(id);
        originalAccount.setAccountName(newAccountData.getAccountName());
        originalAccount.setAccountNumber(newAccountData.getAccountNumber());
        originalAccount.setAccountType(newAccountData.getAccountType());
        originalAccount.setAmount(newAccountData.getAmount());
        originalAccount = accountRepository.save(originalAccount);
        return originalAccount;
    }

    public Account delete(Long id){
        Account accountInDb = read(id);
        accountRepository.delete(accountInDb);
        return accountInDb;
    }

    public Account delete(Account account){
        return delete(account.getId());
    }

}
