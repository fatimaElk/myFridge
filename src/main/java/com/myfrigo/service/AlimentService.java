package com.myfrigo.service;

import com.myfrigo.domain.Aliment;
import com.myfrigo.domain.Category;

import java.util.List;
import java.util.Set;

public interface AlimentService {

    // C
    Aliment addNewAliment (Aliment aliment);

    // R
    List<Aliment> getAll ();
    Aliment getAlimentById(Long id);
    List<Aliment> getAlimentsByUser (Long idUser);
    List<Aliment>getAllAlimentByCategory(Long id);
    // U
    Aliment updateAliment (Aliment aliment);

    // D
    void deleteAliment (Long idAliment);

















}
