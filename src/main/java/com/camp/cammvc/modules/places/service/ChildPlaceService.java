package com.camp.cammvc.modules.places.service;

import com.camp.cammvc.modules.places.entity.ChildPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChildPlaceService {

    public Page<ChildPlace> getAllChildPlace(Pageable pageable);

    public  ResponseEntity<?> registerChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> updateChildPlace(ChildPlace childPlace);

    public  ResponseEntity<?> deleteChildPlace(ChildPlace childPlace);

    public  ChildPlace findChildPlaceById(long id);

    public  ResponseEntity<?>  deleteById(Long id);
}
