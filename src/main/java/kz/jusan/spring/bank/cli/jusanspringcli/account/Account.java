package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

// В данном проекте основным доменом является счет Account
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Account {
    AccountType accountType;
    long id;
    String clientID;
    long bankID;
    double balance;
    boolean withdrawAllowed;

    @Override
    public String toString() {
        return String.format("Account{accountType='%s', id='%03d%06d', clientID='%s', balance=%.1f, withdrawAllowed=%s}", accountType, bankID, id, clientID, balance, withdrawAllowed);
    }
}
