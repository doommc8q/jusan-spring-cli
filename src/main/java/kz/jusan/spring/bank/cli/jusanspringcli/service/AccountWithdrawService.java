package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.accountsType.AccountWithdraw;
import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    boolean withdraw(double amount, AccountWithdraw account);
}
