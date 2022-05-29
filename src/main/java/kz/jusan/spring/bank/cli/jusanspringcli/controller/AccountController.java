package kz.jusan.spring.bank.cli.jusanspringcli.controller;

import kz.jusan.spring.bank.cli.jusanspringcli.output.OutputBody;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountTransactionBalanceRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountUpdateRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.TransferRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import kz.jusan.spring.bank.cli.jusanspringcli.service.AccountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountController {
    @Autowired
    AccountService accountService;

    final CurrentData currentData = new CurrentData();

    @GetMapping
    public OutputBody getAccounts() {
        return accountService.getAccount(currentData.timestamp());
    }

    @GetMapping("/{accountId}")
    public OutputBody getAccountByAccountId(@PathVariable Long accountId) {
        return accountService.getAccountByAccountId(accountId, currentData.timestamp());
    }

    @GetMapping("/{accountId}/transactions")
    public OutputBody getAccountTransactions(@PathVariable Long accountId) {
        return accountService.getAccountTransactions(accountId, currentData.timestamp());
    }

    @PostMapping
    public OutputBody createAccount(@RequestBody AccountRequest accountRequest) {
        return accountService.createAccount(accountRequest, currentData.timestamp());
    }

    @PutMapping("/{accountId}")
    public OutputBody updateAccount(@RequestBody AccountUpdateRequest accountUpdateRequest, @PathVariable Long accountId) {
        return accountService.updateAccount(accountUpdateRequest, accountId, currentData.timestamp());
    }

    @DeleteMapping("/{accountId}")
    public OutputBody deleteStudent(@PathVariable Long accountId) {
        return accountService.deleteAccount(accountId, currentData.timestamp());
    }

    @PostMapping(value = "/{accountId}/deposit")
    public OutputBody accountDepositTransaction(@RequestBody AccountTransactionBalanceRequest accountTransactionBalance, @PathVariable Long accountId) {
        return accountService.depositTransaction(accountTransactionBalance, accountId, currentData.timestamp());
    }

    @PostMapping("/{accountId}/withdraw")
    public OutputBody accountWithdrawTransaction(@RequestBody AccountTransactionBalanceRequest accountTransactionBalance, @PathVariable Long accountId) {
        return accountService.withdrawTransaction(accountTransactionBalance, accountId, currentData.timestamp());
    }

    @PostMapping("/{accountId}/transfer")
    public OutputBody transferMoneyBetweenAccounts(@RequestBody TransferRequest transferRequest, @PathVariable Long accountId) {
        return accountService.transferMoneyBetweenAccounts(transferRequest, accountId, currentData.timestamp());
    }
}
