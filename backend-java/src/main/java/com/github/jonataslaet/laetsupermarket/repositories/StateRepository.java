package com.github.jonataslaet.laetsupermarket.repositories;

import com.github.jonataslaet.laetsupermarket.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
