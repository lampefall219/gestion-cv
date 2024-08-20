package com.projet1.projet.repository;


import com.projet1.projet.model.Compte;
import com.projet1.projet.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

    @Query("SELECT u FROM Compte u WHERE u.email = :email AND u.password = :password")
    Compte findByEmail(@Param("email") String email, @Param("password") String password);


}
