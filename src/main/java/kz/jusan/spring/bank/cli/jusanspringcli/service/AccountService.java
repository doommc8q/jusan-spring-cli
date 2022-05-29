package kz.jusan.spring.bank.cli.jusanspringcli.service;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Transaction;
import kz.jusan.spring.bank.cli.jusanspringcli.output.OutputBody;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.AccountRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.TransactionRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountTransactionBalanceRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.AccountUpdateRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.request.TransferRequest;
import kz.jusan.spring.bank.cli.jusanspringcli.util.ConstantMessages;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response.Status;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public OutputBody getAccount(String timestamp) {
        Iterable<Account> iterable = accountRepository.findAll();
        return new OutputBody(ConstantMessages.ACCOUNT_LIST, timestamp, Status.OK, Streamable.of(iterable).toList());
    }

    public OutputBody getAccountByAccountId(Long accountId, String timestamp) {
        if (accountRepository.findById(accountId).isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        return new OutputBody(ConstantMessages.ACCOUNT_DATA, timestamp, Status.OK, accountRepository.findById(accountId));
    }

    public OutputBody getAccountTransactions(Long accountId, String timestamp) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        Iterable<Transaction> iterable = transactionRepository.findAllByAccountId(accountId);
        return new OutputBody(ConstantMessages.ACCOUNT_DATA, timestamp, Status.OK, Streamable.of(iterable).toList());
    }

    @Transactional
    public OutputBody createAccount(AccountRequest accountRequest, String timestamp) {
        long accountType = 0L;
        if (accountRequest.getAccountType() == null
                || accountRequest.getClientId() == null
                || accountRequest.getBankId() == null) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }

        switch (accountRequest.getAccountType().toLowerCase()) {
            case "checking" -> accountType = 1L;
            case "saving" -> accountType = 2L;
            case "fixed" -> accountType = 3L;
        }

        try {
            Double num = Double.parseDouble(accountRequest.getClientId());
        } catch (NumberFormatException e) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }

        if (accountType == 0L || accountRequest.getClientId().equals("") || accountRequest.getBankId() < 1)
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);

        Account account = Account.builder().build();
        Account accountWithoutFID = accountRepository.save(account);

        if (accountRepository.findById(accountWithoutFID.getAccountId()).isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        String fullAccountId = String.format("%03d%06d", accountRequest.getBankId(), accountWithoutFID.getAccountId());
        Account accountBuilder = Account.builder().
                accountId(accountWithoutFID.getAccountId()).
                fullAccountId(fullAccountId).
                accountTypeId(accountType).
                clientId(accountRequest.getClientId()).
                bankId(accountRequest.getBankId()).
                balance(0.0).
                build();

        return new OutputBody(ConstantMessages.ACCOUNT_CREATED, timestamp, Status.OK, accountRepository.save(accountBuilder));
    }

    public OutputBody updateAccount(AccountUpdateRequest accountUpdateRequest, Long accountId, String timestamp) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }
        boolean didUpdated = false;
        boolean didUpdatedBody = false;
        try {
            if (accountUpdateRequest.getClientId() != null) {
                Double num = Double.parseDouble(accountUpdateRequest.getClientId());
            }
        } catch (NumberFormatException e) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }

        if (accountUpdateRequest.getClientId() != null &&
                accountUpdateRequest.getBankId() != null &&
                (accountUpdateRequest.getClientId().equals("") || accountUpdateRequest.getBankId() < 1))
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);


        if (accountUpdateRequest.getBankId() == null) accountUpdateRequest.setBankId(account.get().getBankId());
        else if (accountUpdateRequest.getBankId().equals(account.get().getBankId())) didUpdatedBody = true;
        else didUpdated = true;

        if (accountUpdateRequest.getClientId() == null) accountUpdateRequest.setClientId(account.get().getClientId());
        else if (accountUpdateRequest.getClientId().equals(account.get().getClientId())) didUpdatedBody = true;
        else didUpdated = true;


        if (!didUpdated || !didUpdatedBody)
            return new OutputBody(ConstantMessages.ACCOUNT_NOTHING_TO_UPDATE, timestamp, Status.NOT_MODIFIED, null);

        String fullAccountId = String.format("%03d%06d", accountUpdateRequest.getBankId(), account.get().getAccountId());

        Account accountBuilder = Account.builder().
                accountId(account.get().getAccountId()).
                fullAccountId(fullAccountId).
                accountTypeId(account.get().getAccountTypeId()).
                clientId(accountUpdateRequest.getClientId()).
                bankId(accountUpdateRequest.getBankId()).
                balance(account.get().getBalance()).
                build();

        return new OutputBody(ConstantMessages.ACCOUNT_UPDATED, timestamp, Status.OK, accountRepository.save(accountBuilder));
    }

    @Transactional
    public OutputBody deleteAccount(Long accountId, String timestamp) {
        if (accountRepository.findById(accountId).isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }
        Iterable<Transaction> iterable = transactionRepository.findAllByAccountId(accountId);
        if (Streamable.of(iterable).toList().size() > 0) {
            transactionRepository.deleteByAccountId(accountId);
        }
        accountRepository.deleteById(accountId);
        return new OutputBody(ConstantMessages.ACCOUNT_DELETED, timestamp, Status.OK, null);
    }

    @Transactional
    public OutputBody depositTransaction(AccountTransactionBalanceRequest accountTransactionBalance, Long accountId, String timestamp) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        if (accountTransactionBalance.getAmount() < 0) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }
        Account accountBuilder = Account.builder().
                accountId(accountId).
                fullAccountId(account.get().getFullAccountId()).
                accountTypeId(account.get().getAccountTypeId()).
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                balance(account.get().getBalance() + accountTransactionBalance.getAmount()).
                build();
        Account depositTransaction = accountRepository.save(accountBuilder);
        Transaction transactionBuilder = Transaction.builder().
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                amount(accountTransactionBalance.getAmount()).
                accountId(accountId).
                transactionData(timestamp).
                completed(true).
                transactionTypeId(1L).
                build();
        transactionRepository.save(transactionBuilder);

        return new OutputBody(ConstantMessages.ACCOUNT_BALANCE_CHANGED, timestamp, Status.OK, depositTransaction);
    }

    @Transactional
    public OutputBody withdrawTransaction(AccountTransactionBalanceRequest accountTransactionBalance, Long accountId, String timestamp) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        if (account.get().getAccountTypeId() == 3L) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_WITHDRAWN, timestamp, Status.METHOD_NOT_ALLOWED, null);
        }

        if (accountTransactionBalance.getAmount() < 0) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }

        if (accountTransactionBalance.getAmount() > account.get().getBalance()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_ENOUGH_MONEY, timestamp, Status.METHOD_NOT_ALLOWED, null);
        }

        Account accountBuilder = Account.builder().
                accountId(accountId).
                fullAccountId(account.get().getFullAccountId()).
                accountTypeId(account.get().getAccountTypeId()).
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                balance(account.get().getBalance() - accountTransactionBalance.getAmount()).
                build();
        Account withdrawTransaction = accountRepository.save(accountBuilder);
        Transaction transactionBuilder = Transaction.builder().
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                amount(accountTransactionBalance.getAmount()).
                accountId(accountId).
                transactionData(timestamp).
                completed(true).
                transactionTypeId(2L).
                build();
        transactionRepository.save(transactionBuilder);

        return new OutputBody(ConstantMessages.ACCOUNT_BALANCE_CHANGED, timestamp, Status.OK, withdrawTransaction);
    }

    // на фиксед можно  переводить а наорот нельзя
    @Transactional
    public OutputBody transferMoneyBetweenAccounts(TransferRequest transferRequest, Long accountId, String timestamp) {
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Account> destinationAccount = accountRepository.findById(transferRequest.getDestinationAccountId());

        if (account.isEmpty() || destinationAccount.isEmpty()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_EXIST, timestamp, Status.NOT_FOUND, null);
        }

        if (accountId.equals(transferRequest.getDestinationAccountId())) {
            return new OutputBody(ConstantMessages.ACCOUNT_CON_NOT_SEND_TO_HIMSELF, timestamp, Status.BAD_REQUEST, null);
        }

        if (account.get().getAccountTypeId() == 3L) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_WITHDRAWN, timestamp, Status.METHOD_NOT_ALLOWED, null);
        }

        if (transferRequest.getAmount() < 0) {
            return new OutputBody(ConstantMessages.INCORRECT_BODY_REQUEST, timestamp, Status.BAD_REQUEST, null);
        }

        if (transferRequest.getAmount() > account.get().getBalance()) {
            return new OutputBody(ConstantMessages.ACCOUNT_NOT_ENOUGH_MONEY, timestamp, Status.METHOD_NOT_ALLOWED, null);
        }

        Account accountBuilder1 = Account.builder().
                accountId(accountId).
                fullAccountId(account.get().getFullAccountId()).
                accountTypeId(account.get().getAccountTypeId()).
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                balance(account.get().getBalance() - transferRequest.getAmount()).
                build();
        accountRepository.save(accountBuilder1);

        Transaction transactionBuilder1 = Transaction.builder().
                clientId(account.get().getClientId()).
                bankId(account.get().getBankId()).
                amount(transferRequest.getAmount()).
                accountId(accountId).
                transactionData(timestamp).
                completed(true).
                transactionTypeId(2L).
                build();
        transactionRepository.save(transactionBuilder1);

        Account accountBuilder2 = Account.builder().
                accountId(transferRequest.getDestinationAccountId()).
                fullAccountId(destinationAccount.get().getFullAccountId()).
                accountTypeId(destinationAccount.get().getAccountTypeId()).
                clientId(destinationAccount.get().getClientId()).
                bankId(destinationAccount.get().getBankId()).
                balance(destinationAccount.get().getBalance() + transferRequest.getAmount()).
                build();
        accountRepository.save(accountBuilder2);

        Transaction transactionBuilder2 = Transaction.builder().
                clientId(destinationAccount.get().getClientId()).
                bankId(destinationAccount.get().getBankId()).
                amount(transferRequest.getAmount()).
                accountId(transferRequest.getDestinationAccountId()).
                transactionData(timestamp).
                completed(true).
                transactionTypeId(1L).
                build();
        transactionRepository.save(transactionBuilder2);

        return new OutputBody(ConstantMessages.ACCOUNT_MONEY_TRANSFERRED_SUCCESS, timestamp, Status.OK, null);
    }
}
