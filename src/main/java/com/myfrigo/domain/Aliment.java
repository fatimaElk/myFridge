package com.myfrigo.domain;

import com.myfrigo.model.security.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "Aliments")
public class Aliment {

    // =================================
    // ========== Attributes ===========
    // =================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate storageDate;

    private LocalDate expirationDate;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    private boolean sharable;

    @ManyToOne
    private Category categorie;

    @Column(nullable = false)
    private int quantity;


    // =================================
    // ========= Constructors ==========
    // =================================




    // =================================
    // ======= Getters & Setters =======
    // =================================


    // =================================
    // =========== Methods =============
    // =================================



}
