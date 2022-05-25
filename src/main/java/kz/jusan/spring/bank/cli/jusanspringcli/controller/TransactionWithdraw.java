package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountWithdraw;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.TransactionDAO;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.transactionType.TransactionType;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    public void execute(AccountWithdraw accountWithdraw, double amount) {
        boolean isChanged = accountWithdrawService.withdraw(amount, accountWithdraw);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        UUID uuid = UUID.randomUUID();
        Transaction transaction = null;
        if (isChanged) {
            transaction = new Transaction(uuid.toString(), accountWithdraw.getClientId(), accountWithdraw.getId(),
                    dtf.format(localDateTime), amount, TransactionType.WITHDRAW_MONEY, true);
        } else {
            transaction = new Transaction(uuid.toString(), accountWithdraw.getClientId(), accountWithdraw.getId(),
                    dtf.format(localDateTime), amount, TransactionType.WITHDRAW_MONEY, false);
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
