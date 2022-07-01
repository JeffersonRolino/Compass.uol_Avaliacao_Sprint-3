package com.github.JeffersonRolino.AvaliacaoSprint3.repository;

import com.github.JeffersonRolino.AvaliacaoSprint3.model.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
