package kz.jusan.spring.bank.cli.jusanspringcli.entity;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

// В данном проекте основным доменом является счет Account
@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    String id;
    AccountType accountType;
    String clientId;
    Long bankId;
    double balance;
    boolean withdrawAllowed;

    @Override
    public String toString() {
        return String.format("Account{accountType='%s', id='%s', clientId='%s', balance=%.1f, withdrawAllowed=%s}", accountType, id, clientId, balance, withdrawAllowed);
    }
}
