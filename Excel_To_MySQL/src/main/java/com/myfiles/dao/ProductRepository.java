package com.myfiles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfiles.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
