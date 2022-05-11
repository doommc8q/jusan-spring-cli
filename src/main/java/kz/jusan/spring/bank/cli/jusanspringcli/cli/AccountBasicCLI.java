package kz.jusan.spring.bank.cli.jusanspringcli.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.account.AccountListingService;
import kz.jusan.spring.bank.cli.jusanspringcli.bank.BankCore;
import kz.jusan.spring.bank.cli.jusanspringcli.account.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountBasicCLI {
    CreateAccountOperationUI createAccountOperationUI;
    BankCore bankCore;
    AccountListingService accountListing;

    public void createAccountRequest(String clientID) {
        AccountType accountType = createAccountOperationUI.requestAccountType();
        if (accountType == null) {
            return;
        }
        bankCore.createNewAccount(accountType, clientID);
    }

    public void getAccounts(String clientID) {
        List<Account> accounts = accountListing.getClientAccounts(clientID);
        System.out.println(accounts);
    }
}
