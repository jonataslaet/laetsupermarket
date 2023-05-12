package com.github.jonataslaet.laetsupermarket.repositories;

import com.github.jonataslaet.laetsupermarket.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
