package kz.jusan.spring.bank.cli.jusanspringcli.withdraw;

import kz.jusan.spring.bank.cli.jusanspringcli.dao.AccountDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
    AccountDAO accountDAO;

    @Override
    public void withdraw(double amount, AccountWithdraw account) {
        double balance = accountDAO.getClientAccount(account.getClientID(), String.valueOf(account.getId())).getBalance();

        if (balance > amount && account.isWithdrawAllowed()) {
            AccountWithdraw accountWithdraw = accountDAO.getClientWithdrawAccount(account.getClientID(), String.valueOf(account.getId()));
            accountWithdraw.setBalance(balance - amount);
            accountDAO.updateAccount(account, accountWithdraw);
            System.out.printf("%.2f$ transferred from %03d%06d account\n", amount, account.getBankID(), account.getId());
        } else {
            if (!account.isWithdrawAllowed()) {
                System.out.println("From fixed account you can not to withdraw money");
            } else {
                System.out.println("Not enough money to withdraw");
            }
        }
    }


}
