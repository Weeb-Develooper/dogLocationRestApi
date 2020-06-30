package com.osas.locationapi.web;
import com.osas.locationapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {
    DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/")
    public ResponseEntity<List<String>> getDogBreeds(){
       List<String> listOfBreeds = dogService.retrieveDogBreed();
       return new ResponseEntity<List<String>>(listOfBreeds, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> listOfNames = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(listOfNames,HttpStatus.OK);
    }

    @GetMapping("{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        String breedById = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breedById,HttpStatus.OK);
    }

}
