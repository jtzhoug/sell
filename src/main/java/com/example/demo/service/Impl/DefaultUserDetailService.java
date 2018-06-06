package com.example.demo.service.Impl;

import com.example.demo.dataObject.Account;
import com.example.demo.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DefaultUserDetailService implements UserDetailsService{
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Account account=accountRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return new User(
                account.getUsername(),
                account.getPassword(),
                AuthorityUtils.NO_AUTHORITIES
        );
    }
}
