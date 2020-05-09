package com.swagger2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swagger2.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
