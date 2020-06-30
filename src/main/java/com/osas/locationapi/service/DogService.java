package com.osas.locationapi.service;

import java.util.List;

public interface DogService {
     List<String> retrieveDogBreed();
     String retrieveDogBreedById(Long id);
     List<String> retrieveDogNames();
}
