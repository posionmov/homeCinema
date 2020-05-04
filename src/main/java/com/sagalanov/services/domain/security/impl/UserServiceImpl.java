package com.sagalanov.services.domain.security.impl;

import com.sagalanov.models.auth.Role;
import com.sagalanov.models.auth.User;
import com.sagalanov.repositories.RoleRepository;
import com.sagalanov.repositories.UserRepository;
import com.sagalanov.services.domain.security.interfaces.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.sagalanov.constants.auth.AuthConstants.DEFAULT_ROLE;
import static com.sagalanov.constants.auth.AuthConstants.ROLE_PREFIX;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    private static final String ROLE = ROLE_PREFIX + DEFAULT_ROLE;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>(Collections.singletonList(roleRepository.findRoleByName(ROLE)));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
