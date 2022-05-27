package kz.jusan.spring.bank.cli.jusanspringcli.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentData {
    public String timestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dtf.format(localDateTime);
    }
}
