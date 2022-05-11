package kz.jusan.spring.bank.cli.jusanspringcli.deposit;

import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountListingService;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.AccountWithdraw;
import kz.jusan.spring.bank.cli.jusanspringcli.withdraw.WithdrawDepositOperationCLIUI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class TransactionDepositCLI {
    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;

    public void depositMoney(String clientID) {
        //fix duplicate
        System.out.println("Type account ID");
        String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id.equals("")) {
            System.out.println("Not excepted id");
            return;
        }
        AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, id);

        System.out.println("Type Amount of money");
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount < 0) {
            System.out.println("Not excepted amount of money");
            return;
        }
        transactionDeposit.execute(accountWithdraw, amount);
    }
}
