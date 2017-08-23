package com.where.server.security;


import com.where.server.repository.PrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class WhereUserDetailsService implements UserDetailsService {

    private final PrincipalRepository principalRepository;

    @Autowired
    public WhereUserDetailsService(PrincipalRepository principalRepository) {
        this.principalRepository = principalRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return principalRepository.findByUsername(username)
                .map(principal -> User.withUsername(principal.getUsername())
                        .password(principal.getPassword())
                        .disabled(!principal.isEnabled())
                        .authorities(principal.getPermission().name())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
