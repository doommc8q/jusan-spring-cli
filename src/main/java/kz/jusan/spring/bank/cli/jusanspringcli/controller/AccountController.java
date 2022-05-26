package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.exception.OutputBody;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountTransactionBalance;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountUpdateRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.util.CurrentData;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public OutputBody getAccounts() {
        CurrentData currentData = new CurrentData();
        return accountService.getAccount(currentData.timestamp());
    }

    @GetMapping("/{accountId}")
    public OutputBody getAccountByAccountId(@PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.getAccountByAccountId(accountId, currentData.timestamp());
    }

    @GetMapping("/{accountId}/transactions")
    public OutputBody getAccountTransactions(@PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.getAccountTransactions(accountId, currentData.timestamp());
    }

    @PostMapping
    public OutputBody createAccount(@RequestBody AccountRequest accountRequest) {
        CurrentData currentData = new CurrentData();
        return accountService.createAccount(accountRequest, currentData.timestamp());
    }

    @PutMapping("/{accountId}")
    public OutputBody updateAccount(@RequestBody AccountUpdateRequest accountUpdateRequest, @PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.updateAccount(accountUpdateRequest, accountId, currentData.timestamp());
    }

    @DeleteMapping("/{accountId}")
    public OutputBody deleteStudent(@PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.deleteAccount(accountId, currentData.timestamp());
    }

    @PostMapping(value = "/{accountId}/deposit")
    public OutputBody accountDepositTransaction(@RequestBody AccountTransactionBalance accountTransactionBalance, @PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.depositTransaction(accountTransactionBalance, accountId, currentData.timestamp());
    }

    @PostMapping("/{accountId}/withdraw")
    public OutputBody accountWithdrawTransaction(@RequestBody AccountTransactionBalance accountTransactionBalance, @PathVariable Long accountId) {
        CurrentData currentData = new CurrentData();
        return accountService.withdrawTransaction(accountTransactionBalance, accountId, currentData.timestamp());
    }
}
