package mainApp.services;

import mainApp.entities.AppUser;
import mainApp.entities.Transaction;
import mainApp.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionsByUser(AppUser appUser) {
        return transactionRepository.findByAppUser(appUser);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
