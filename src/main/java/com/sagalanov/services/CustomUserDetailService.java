package com.sagalanov.services;

import com.sagalanov.models.auth.User;
import com.sagalanov.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }

        Set<GrantedAuthority> grantedAuthorities
                = user.getRoles()
                    .stream()
                    .map(el -> new SimpleGrantedAuthority(el.getName()))
                    .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                        user.getPassword(),
                                                                        grantedAuthorities);
    }
}
