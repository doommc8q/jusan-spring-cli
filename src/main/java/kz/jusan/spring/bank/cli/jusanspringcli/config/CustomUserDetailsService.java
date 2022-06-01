package kz.jusan.spring.bank.cli.jusanspringcli.config;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Role;
import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import kz.jusan.spring.bank.cli.jusanspringcli.service.UserService;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CurrentData currentData = new CurrentData();
        Users user = userService.getUserByUsername(username, currentData.timestamp());

        if (user == null) {
            return null;
        }
        Role role = userService.getRoleById(user.getRoleId());
        if (role == null) {
            return null;
        }
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user, role.getRoleType());

    }
}
