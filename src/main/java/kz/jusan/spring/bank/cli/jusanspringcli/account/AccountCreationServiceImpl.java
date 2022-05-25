package kz.jusan.spring.bank.cli.jusanspringcli.account;

import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.AccountType;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.CheckingAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.FixedAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.accountsType.SavingAccount;
import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCreationServiceImpl implements AccountCreationService {
    final AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, Long bankID, String clientID, String accountID) {
        Account account = null;
        if (accountType.equals(AccountType.SAVING)) {
            account = new SavingAccount(accountID, accountType, clientID, bankID, 0.0, true);
        } else if (accountType.equals(AccountType.FIXED)) {
            account = new FixedAccount(accountID, accountType, clientID, bankID, 0.0, false);
        } else if (accountType.equals(AccountType.CHECKING)) {
            account = new CheckingAccount(accountID, accountType, clientID, bankID, 0.0, true);
        }
        if (account == null) {
            System.out.println("Error while creating new account");
        }  else {
            accountDAO.createAccount(account.getId(),account.getAccountType().toString(),account.getClientId(),account.getBankId(),account.getBalance(),account.isWithdrawAllowed());
            System.out.println("Bank account created");
        }
    }
}
