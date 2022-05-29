package kz.jusan.spring.bank.cli.jusanspringcli.config;

import kz.jusan.spring.bank.cli.jusanspringcli.entity.User;
import kz.jusan.spring.bank.cli.jusanspringcli.repository.UserRepository;
import kz.jusan.spring.bank.cli.jusanspringcli.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> {
                    throw new UsernameNotFoundException("User doesn't exist");
                }
        );
        return new SecurityUser(user);
    }
}
