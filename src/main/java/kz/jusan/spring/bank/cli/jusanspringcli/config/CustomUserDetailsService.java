package kz.jusan.spring.bank.cli.jusanspringcli.config;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.Users;
import kz.jusan.spring.bank.cli.jusanspringcli.service.UserService;
import kz.jusan.spring.bank.cli.jusanspringcli.util.CurrentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CurrentData currentData = new CurrentData();
        Users user =(Users) userService.getUserByUsername(username, currentData.timestamp()).getBody();
        if (user == null) {
            return null;
        }
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);

    }
}
