package kz.jusan.spring.bank.cli.jusanspringcli.controller.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.TransactionDeposit;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.ui.WithdrawDepositOperationCLIUI;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void depositMoney(String clientID) {
        String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id.equals("")) {
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
