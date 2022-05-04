package kz.jusan.spring.bank.cli.jusanspringcli;

// Fixed счета нельзя снимать деньги
public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, id, clientID, balance, withdrawAllowed);
    }
}
