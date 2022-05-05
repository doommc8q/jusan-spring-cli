package kz.jusan.spring.bank.cli.jusanspringcli;

// Fixed счета нельзя снимать деньги
public class FixedAccount extends AccountDeposit {
    public FixedAccount(AccountType accountType, long bankID, long id, String clientID, double balance, boolean withdrawAllowed) {
        super(accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
