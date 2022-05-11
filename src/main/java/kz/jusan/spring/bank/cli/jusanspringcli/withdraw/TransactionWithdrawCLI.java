package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

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
        System.out.println("Type account ID");
        String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (id.equals("")){
            System.out.println("Not excepted id");
            return;
        }
        AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, id);

        System.out.println("Type Amount of money");
        double amount =  withdrawDepositOperationCLIUI.requestClientAmount();
        if (amount < 0) {
            System.out.println("Not excepted amount of money");
            return;
        }
        transactionWithdraw.execute(accountWithdraw, amount);
    }
}
