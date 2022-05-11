package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import org.springframework.stereotype.Service;

@Service
public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw account);
}
