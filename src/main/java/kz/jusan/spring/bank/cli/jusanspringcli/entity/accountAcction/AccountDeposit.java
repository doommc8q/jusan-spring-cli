package kz.jusan.spring.bank.cli.jusanspringcli.entity.accountAcction;


import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;

// AccountDeposit можно только снимать
public class AccountDeposit extends Account {
    public AccountDeposit(Long accountId, String fullAccountId, Long accountTypeId, String clientId, Long bankId, double balance) {
        super(accountId, fullAccountId, accountTypeId, clientId, bankId, balance);
    }
}
