package com.projet1.projet.repository;

import com.projet1.projet.model.CentreInteret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreInteretRepository extends JpaRepository<CentreInteret,Long> {
}
