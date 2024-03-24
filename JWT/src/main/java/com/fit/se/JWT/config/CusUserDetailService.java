package com.fit.se.JWT.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fit.se.JWT.entity.Account;
import com.fit.se.JWT.repository.AccountRepository;

@Component
public class CusUserDetailService implements UserDetailsService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Account> account = accountRepository.finfByUsername(username);
		return account.map(CusUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Not found username: "+username));
	}
	
}
