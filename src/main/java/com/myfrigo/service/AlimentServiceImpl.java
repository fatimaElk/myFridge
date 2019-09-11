package com.myfrigo.service;

import com.myfrigo.domain.Aliment;
import com.myfrigo.domain.Category;
import com.myfrigo.model.security.User;
import com.myfrigo.repository.AlimentRepository;
import com.myfrigo.repository.CategoryRepository;
import com.myfrigo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class AlimentServiceImpl implements AlimentService {


    // =================================
    // ========== Attributes ===========
    // =================================

    private static final Logger LOGGER = LoggerFactory.getLogger(AlimentServiceImpl.class);

    private AlimentRepository alimentRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;



    // =================================
    // ========= Constructors ==========
    // =================================




    // =================================
    // ======= Getters & Setters =======
    // =================================


    // =================================
    // =========== Methods =============
    // =================================


    @Override
    @Transactional
    public Aliment addNewAliment(Aliment aliment) {
        Category category = categoryRepository.findByName(aliment.getCategorie().getName());
        User user = userRepository.findByUsername(aliment.getOwner().getUsername());

        aliment.setOwner(user);
        aliment.setCategorie(category);

        alimentRepository.save(aliment);
        return aliment;
    }

    @Override
    public List<Aliment> getAll() {
        return alimentRepository.findAll();
    }

    @Override
    public Aliment getAlimentById(Long id) {
        return alimentRepository.findAlimentById(id);
    }

    @Override
    public List<Aliment> getAlimentsByUser(Long idUser) {
        User user = userRepository.findUserById(idUser);
        List<Aliment> aliments = alimentRepository.findAllByOwnerContains(user);
        return aliments;
    }

    @Override
    public List<Aliment> getAllAlimentByCategory(Long id) {
        List<Aliment> aliments = new ArrayList<>();
        try {
            Category category = categoryRepository.findById(id).orElse(null);
            aliments = category.getAliments();
            return aliments;
        } catch (Exception e) {
            LOGGER.error("error alimentServiceImpl: ");
        }
        return aliments;
    }

    @Override
    public Aliment updateAliment(Aliment aliment) {
        Aliment alimentToChange = alimentRepository.findAlimentById(aliment.getId());

        // Update de l'aliment
        if (aliment.getName() != null) {
            alimentToChange.setName(aliment.getName());
        }
        if (aliment.getCategorie() != null) {
            alimentToChange.setCategorie(aliment.getCategorie());
        }
        if (aliment.getExpirationDate() != null) {
            alimentToChange.setExpirationDate(aliment.getExpirationDate());
        }
        if (aliment.getStorageDate() != null) {
            alimentToChange.setStorageDate(aliment.getStorageDate());
        }
        if (aliment.isSharable() != alimentToChange.isSharable()) {
            alimentToChange.setSharable(aliment.isSharable());
        }
        if (aliment.getOwner() != null) {
            alimentToChange.setOwner(aliment.getOwner());
        }
        if (aliment.getQuantity() != alimentToChange.getQuantity()) {
            alimentToChange.setQuantity(aliment.getQuantity());
        }

        alimentRepository.save(alimentToChange);
        return alimentToChange;


    }

    @Override
    public void deleteAliment(Long idAliment) {

        Aliment aliment = alimentRepository.findAlimentById(idAliment);
        alimentRepository.delete(aliment);
    }




}
