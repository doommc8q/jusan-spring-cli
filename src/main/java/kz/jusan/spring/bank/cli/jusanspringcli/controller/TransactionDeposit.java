package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.transactionType.TransactionType;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountDepositService;
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

    public void execute(Account account, double amount) {
        boolean isCompleted = accountDepositService.deposit(amount, account);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        UUID uuid = UUID.randomUUID();
        Transaction transaction = null;
        if (isCompleted) {
            transaction = new Transaction(uuid.toString(), account.getClientId(), account.getId(),
                    dtf.format(localDateTime), amount, TransactionType.ADD_MONEY, true);
        } else {
            transaction = new Transaction(uuid.toString(), account.getClientId(), account.getId(),
                    dtf.format(localDateTime), amount, TransactionType.ADD_MONEY, false);

        }
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
