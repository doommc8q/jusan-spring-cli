package kz.jusan.spring.bank.cli.jusanspringcli;

public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing) {
        this.accountListing = accountListing;
        this.bankCore = bankCore;
        this.createAccountOperationUI = createAccountOperationUI;
    }
    public void createAccountRequest(String clientID) {}
    public void getAccount(String clientID){}

}
