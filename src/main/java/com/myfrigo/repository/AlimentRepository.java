package com.myfrigo.repository;

import com.myfrigo.domain.Aliment;
import com.myfrigo.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlimentRepository extends JpaRepository<Aliment, Long> {

    // C

    // R
    Aliment findAlimentById (Long id);
    List<Aliment> findAll();
    List<Aliment> findAllByOwnerContains (User user);

    // U

    // D

}
