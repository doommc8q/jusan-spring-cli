package kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType;

// Checking счетов можно снимать и пополнять
public class CheckingAccount extends AccountWithdraw {
    public CheckingAccount(String id,AccountType accountType,  String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id,accountType, clientID, bankID, balance, withdrawAllowed);
    }
}