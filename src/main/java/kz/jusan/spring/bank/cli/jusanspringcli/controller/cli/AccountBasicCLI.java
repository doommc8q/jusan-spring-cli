package kz.jusan.spring.bank.cli.jusanspringcli.controller.cli;

import kz.jusan.spring.bank.cli.jusanspringcli.controller.ui.CreateAccountOperationUI;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountListingService;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountType;
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
        System.out.println("""
                        Choose account type:
                        [CHECKING, SAVING, FIXED]""");
        AccountType accountType = createAccountOperationUI.requestAccountType();
        if (accountType == null) {
            return;
        }
        bankCore.createNewAccount(accountType, clientID);
    }

    public void getAccounts(String clientID) {
        List<Account> accounts = accountListing.getClientAccounts(clientID);
        System.out.println("[");
        for (Account a : accounts) {
            System.out.println(a);
        }
        System.out.println("]");
    }
}
