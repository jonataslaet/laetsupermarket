package com.github.jonataslaet.laetsupermarket.repositories;

import com.github.jonataslaet.laetsupermarket.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
