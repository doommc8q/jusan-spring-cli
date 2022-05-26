package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
