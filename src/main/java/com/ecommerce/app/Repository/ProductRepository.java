package com.ecommerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
