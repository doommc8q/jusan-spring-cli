package kz.jusan.spring.bank.cli.jusanspringcli.controller.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.TransactionWithdraw;
import kz.jusan.spring.bank.cli.jusanspringcli.controller.ui.WithdrawDepositOperationCLIUI;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountListingService;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI {
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void withdrawMoney(String clientID) {
        String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id.equals("")) {
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
