package kz.jusan.spring.bank.cli.jusanspringcli;

public class AccountCreationServiceImpl implements AccountCreationService{
    private AccountDAO accountDAO;

    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID) {
        Account account = new Account(accountType,String.valueOf(accountID), clientID,0.0,true);
        accountDAO.createNewAccount(account);
    }
}
