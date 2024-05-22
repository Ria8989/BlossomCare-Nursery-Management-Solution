package com.spe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spe.Entity.Cart;


public interface CartRepository extends JpaRepository<Cart,Integer>{

}
