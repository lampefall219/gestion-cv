package com.projet1.projet.repository;


import com.projet1.projet.model.SystemeEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemeExRepository extends JpaRepository<SystemeEx,Long> {
}
