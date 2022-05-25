package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountDepositService {
    boolean deposit(double amount, Account account);
}
