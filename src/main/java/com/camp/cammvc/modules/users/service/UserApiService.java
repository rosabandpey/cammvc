package com.camp.cammvc.modules.users.service;

import com.camp.cammvc.modules.users.entity.AppUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserApiService {

    public List<AppUser> getByUsername(String username);
    public List<AppUser> getAllUsers();
    public ResponseEntity<?> login(AppUser appUser);
    public  ResponseEntity<?> register(AppUser appUser);
    public  String logout();
    public AppUser findUserByUsername(String username);
    public AppUser findUserById(long id);
    public ResponseEntity<?>  deleteUserById(long id);
}
