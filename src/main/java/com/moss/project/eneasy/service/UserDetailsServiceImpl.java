package com.moss.project.eneasy.service;

import com.moss.project.eneasy.repository.UserRepository;
import com.moss.project.eneasy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepository.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        log.info("loadUserByUsername() : {}", username);

        return org.springframework.security.core.userdetails.User.builder()
                .username(users.getUsername())
                //change here to store encoded password in db
                .password( bCryptPasswordEncoder.encode(users.getPassword()) )
                /*
                .disabled(users.isDisabled())
                .accountExpired(users.isAccountExpired())
                .accountLocked(users.isAccountLocked())
                .credentialsExpired(users.isCredentialsExpired())
                 */
                .roles(users.getAuthorities().toArray(new String[0]))
                .build();
    }
}