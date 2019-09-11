package com.myfrigo.rest;

import com.myfrigo.domain.Aliment;
import com.myfrigo.domain.Category;
import com.myfrigo.repository.UserRepository;
import com.myfrigo.service.AlimentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin// ou @CrossOrigin(*) on peut spécifier aussi
@RestController
@RequestMapping("/aliment")//ou name=" "
@AllArgsConstructor
public class AlimentRest {

    // =================================
    // ========== Attributes ===========
    // =================================

    private static final Logger LOGGER = LoggerFactory.getLogger(AlimentRest.class);
    private AlimentService alimentService;

    // =================================
    // ========= Constructors ==========
    // =================================




    // =================================
    // ======= Getters & Setters =======
    // =================================


    // =================================
    // =========== Methods =============
    // =================================

    @PostMapping("/newAliment")
    public ResponseEntity<?> addNewAliment(@RequestBody Aliment aliment){
        try{
            aliment = alimentService.addNewAliment(aliment);
            return new ResponseEntity<>(aliment, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error :" + e, HttpStatus.CONFLICT);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {//si pas même nom le préciser ds @PathVariable("autreNom")
        Aliment aliment = alimentService.getAlimentById(id);
        return new ResponseEntity<>(aliment, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> allProducts() {
        List<Aliment> aliments = alimentService.getAll();
        return new ResponseEntity<>(aliments, HttpStatus.OK);
    }

    @GetMapping("/cat/{id}")
    public ResponseEntity<?> getAlimentByCategory(@PathVariable Long idCategorie) {//si pas même nom le préciser ds @PathVariable("autreNom")
        List<Aliment> aliments = alimentService.getAllAlimentByCategory(idCategorie);

        return new ResponseEntity<>(aliments, HttpStatus.OK);

    }

    @PutMapping("/updateAliment")
    public ResponseEntity<?> updateAliment(@RequestBody Aliment aliment){
        try{
            aliment = alimentService.updateAliment(aliment);
            return new ResponseEntity<>(aliment, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e, HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/deleteAliment")
    public  ResponseEntity<?> deleteAliment(@RequestBody Aliment aliment){
        try{
            alimentService.deleteAliment(aliment.getId());
            return new ResponseEntity<>(aliment, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error : " + e, HttpStatus.CONFLICT);
        }

    }



}
