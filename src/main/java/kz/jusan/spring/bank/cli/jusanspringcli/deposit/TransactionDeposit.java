package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.transaction.Transaction;
import kz.jusan.spring.bank.cli.jusanspringcli.transaction.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    AccountDepositService accountDepositService;
    TransactionDAO transactionDAO;

    void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        UUID uuid = UUID.randomUUID();
        Transaction transaction = new Transaction(uuid.toString(), account.getClientId(), account.getId(),
                dtf.format(localDateTime), amount, TransactionType.ADD_MONEY, true);
        transactionDAO.createTransaction(
                transaction.getTransactionId(),
                transaction.getClientId(),
                transaction.getAccountId(),
                transaction.getTransactionData(),
                transaction.getAmount(),
                transaction.getTransactionType().toString(),
                transaction.isCompleted()
        );
    }

}
