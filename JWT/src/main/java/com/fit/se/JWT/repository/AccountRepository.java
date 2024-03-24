package com.fit.se.JWT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fit.se.JWT.entity.Account;



public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("select a from Account a where a.username =:username")
	Optional<Account> finfByUsername(@Param("username") String username);

}
