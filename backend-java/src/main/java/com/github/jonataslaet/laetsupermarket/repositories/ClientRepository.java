package com.github.jonataslaet.laetsupermarket.repositories;

import com.github.jonataslaet.laetsupermarket.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
