package com.myfrigo.repository;

import com.myfrigo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // C


    // R
    Category findByName (String name);
    // U

    // D

}
