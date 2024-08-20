package com.projet1.projet.repository;


import com.projet1.projet.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification,Long> {
}
