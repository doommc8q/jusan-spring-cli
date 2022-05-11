package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;

// В данном проекте основным доменом является счет Account
@Data
@AllArgsConstructor
public abstract class Account {
    private AccountType accountType;
    private long id;
    private String clientID;
    private long bankID;
    private double balance;
    private boolean withdrawAllowed;

    @Override
    public String toString() {
        return String.format("Account{accountType='%s', id='%03d%06d', clientID='%s', balance=%.1f}", accountType, bankID, id, clientID, balance);
    }
}
