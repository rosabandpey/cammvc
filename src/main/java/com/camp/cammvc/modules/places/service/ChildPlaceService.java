package com.camp.cammvc.modules.places.service;

import com.camp.cammvc.modules.places.entity.ChildPlace;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChildPlaceService {

    public List<ChildPlace> getAllChildPlace();

    public  ResponseEntity<?> registerChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> updateChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> deleteChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> findChildPlaceById(String id);
}
