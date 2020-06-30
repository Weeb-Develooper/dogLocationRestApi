package com.osas.locationapi.service;

import com.osas.locationapi.repository.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class DogServiceImpl implements DogService {
    public DogServiceImpl() {
    }

    DogRepo dog;

    @Autowired
    public void setDog(DogRepo dog) {
        this.dog = dog;
    }

    @Override
    public List<String> retrieveDogBreed() {
        return dog.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
       try{return dog.findBreedById(id);}
       catch(DogNotFoundException ex){
               throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Dog not found");
           }
       }


    @Override
    public List<String> retrieveDogNames() {
        return dog.findAllName();
    }
}
