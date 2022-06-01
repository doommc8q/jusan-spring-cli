package kz.jusan.spring.bank.cli.jusanspringcli.output;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParsedToken {
    String username;
    Long id;
    String role;
}
