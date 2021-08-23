package mainApp.services;

import mainApp.entities.Account;
import mainApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account read(Long id){
        return accountRepository.findById(id).get();
    }

    public Iterable<Account> readAll() {
        return accountRepository.findAll();
    }
    public Account update(Long id,Account newData){
        Account account =read(id);
        account.setAccountName(newData.getAccountName());
        account.setAccountType(newData.getAccountType());
        accountRepository.save(newData);
        return newData;
    }
    public Account delete(Account account) {
        accountRepository.delete(account);
        return account;
    }

    public Account delete(Long id){

        return delete(read(id));
    }

}
