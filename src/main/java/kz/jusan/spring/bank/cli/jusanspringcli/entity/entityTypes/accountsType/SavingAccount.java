package kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType;

// Saving счетов можно снимать и пополнять
public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
