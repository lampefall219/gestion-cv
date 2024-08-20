package com.projet1.projet.repository;

import com.projet1.projet.model.Compte;
import com.projet1.projet.model.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Page<Utilisateur> findAll(Pageable pageable);
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    Utilisateur findByEmail(@Param("email") String email);

}
