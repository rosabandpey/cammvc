package com.camp.cammvc.service;

import com.camp.cammvc.entity.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserApiService {

    public List<AppUser> getByUsername(String username);
    public List<AppUser> getAllUsers();
    public ResponseEntity<?> login(AppUser appUser);
    public  ResponseEntity<?> register(AppUser appUser);
    public  String logout();
}
