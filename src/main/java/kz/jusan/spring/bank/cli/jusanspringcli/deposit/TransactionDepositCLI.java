package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountListingService;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.WithdrawDepositOperationCLIUI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void depositMoney(String clientID) {
        Long id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id == 0L) {
            System.out.println("Not excepted id");
            return;
        }

        Account account = accountListing.getClientAccounts(clientID, id);
        if (account == null) {
            System.out.println("id not correct");
            return;
        }

        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount <= 0) {
            System.out.println("Not excepted amount of money");
            return;
        }
        transactionDeposit.execute(account, amount);
    }
}
