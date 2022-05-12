package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

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
public class TransactionWithdraw {
    AccountWithdrawService accountWithdrawService;
    TransactionDAO transactionDAO;

    void execute(AccountWithdraw accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        UUID uuid = UUID.randomUUID();
        transactionDAO.addTransaction(new Transaction(uuid.toString(), accountWithdraw.getClientID(),
                accountWithdraw.getId(), dtf.format(localDateTime), amount, TransactionType.WITHDRAW_MONEY, true));
    }
}
