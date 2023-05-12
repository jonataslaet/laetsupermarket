package com.github.jonataslaet.laetsupermarket.repositories;

import com.github.jonataslaet.laetsupermarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}