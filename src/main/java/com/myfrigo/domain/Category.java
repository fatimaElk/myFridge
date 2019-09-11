package com.myfrigo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "categories")

public class Category {

    // =================================
    // ========== Attributes ===========
    // =================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany
    private List<Aliment> aliments = new ArrayList<>();




    // =================================
    // ========= Constructors ==========
    // =================================




    // =================================
    // ======= Getters & Setters =======
    // =================================

    public void setAliments(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    public List<Aliment> getAliments() {
        return this.aliments;
    }

    // =================================
    // =========== Methods =============
    // =================================
}
