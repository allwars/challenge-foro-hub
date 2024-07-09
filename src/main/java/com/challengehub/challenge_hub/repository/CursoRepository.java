package com.challengehub.challenge_hub.repository;


import com.challengehub.challenge_hub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
