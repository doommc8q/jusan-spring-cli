package kz.jusan.spring.bank.cli.jusanspringcli;

import java.util.List;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.accountListing = accountListing;
        this.bankCore = bankCore;
        this.createAccountOperationUI = createAccountOperationUI;
    }

    public void createAccountRequest(String clientID) {
        AccountType accountType = createAccountOperationUI.requestAccountType();
        bankCore.createNewAccount(accountType, clientID);
    }

    public void getAccount(String clientID) {
        List<Account> accounts = accountListing.getClientAccounts(clientID);
        System.out.println(accounts);
    }

}
