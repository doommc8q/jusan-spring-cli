package kz.jusan.spring.bank.cli.jusanspringcli;

public class AccountCreationServiceImpl {
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
