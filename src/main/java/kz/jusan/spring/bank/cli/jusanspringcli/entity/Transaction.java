package kz.jusan.spring.bank.cli.jusanspringcli.entity;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.entityTypes.transactionType.TransactionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {
    String TransactionId;
    String clientId;
    String accountId;
    String transactionData;
    double amount;
    TransactionType transactionType;
    boolean completed;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + TransactionId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", transactionData=" + transactionData +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", completed=" + completed +
                '}';
    }
}
