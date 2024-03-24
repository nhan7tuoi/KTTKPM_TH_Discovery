package com.fit.se.JWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fit.se.JWT.entity.Account;
import com.fit.se.JWT.service.AccountService;

@RestController
@RequestMapping("/auth")
public class JWTController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody Account account) {
		return accountService.save(account);
	}
	
	@PostMapping("/login")
	public String getToken(@RequestBody Account account) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

		if (authentication.isAuthenticated()) {
			return accountService.generateToken(account.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		accountService.validateToken(token);
		return "Token is valid";
	}
}
