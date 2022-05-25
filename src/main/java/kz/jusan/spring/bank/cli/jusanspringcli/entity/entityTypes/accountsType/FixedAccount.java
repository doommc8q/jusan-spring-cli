package kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType;

// Fixed счета нельзя снимать деньги
public class FixedAccount extends AccountDeposit {
    public FixedAccount(String id, AccountType accountType, String clientID, Long bankID, double balance, boolean withdrawAllowed) {
        super(id, accountType, clientID, bankID, balance, withdrawAllowed);
    }
}
