package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
