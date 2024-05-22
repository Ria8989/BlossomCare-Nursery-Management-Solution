package com.spe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public Customer findByUserName(String userName);
}
