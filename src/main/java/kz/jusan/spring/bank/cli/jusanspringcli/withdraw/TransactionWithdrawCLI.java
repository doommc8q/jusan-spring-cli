package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void withdrawMoney(String clientID) {
        Long id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id == 0L) {
            System.out.println("Not excepted id");
            return;
        }

        AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, id);
        if (accountWithdraw == null) {
            System.out.println("Account can not use this method");
            return;
        }

        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("Not excepted amount of money");
            return;
        }
        transactionWithdraw.execute(accountWithdraw, amount);
    }
}
