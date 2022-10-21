package com.faProductivity.faProductivity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faProductivity.faProductivity.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String>{

	Optional<Account> findByCustomerNameContainingIgnoreCase(String customerName);
	

}
