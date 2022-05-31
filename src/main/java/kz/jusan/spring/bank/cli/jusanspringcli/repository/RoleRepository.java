package kz.jusan.spring.bank.cli.jusanspringcli.repository;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Role;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends CrudRepository<Users, Long> {
    Optional<Role> findByRoleType(String roleType);
}
