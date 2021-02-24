package com.camp.cammvc.service;

import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.exception.ApiException;
import com.camp.cammvc.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class UserApiServiceImpl {





    @Autowired
    private RestTemplate restTemplate;



    ResponseEntity<ResponseApi> response;

    public ResponseApi getByUsername(String username){
        final String uri="http://localhost:8085/api/authenticate/getByUsername/{username}";
        Map<String,String> params=new HashMap<String,String>();
        params.put("username",username);
        ResponseApi responseApi=restTemplate.getForObject(uri,ResponseApi.class,params);

        if (!responseApi.isSuccessfull()){
            throw new NotFoundException(responseApi.getMessage());
        }
        return responseApi;
    }


    public List<AppUser> getAllUsers(){

        final String uri="http://localhost:8085/api/authenticate/userList";
        return Arrays.stream(restTemplate.getForObject(uri, AppUser[].class)).collect(Collectors.toList());
    }




    public  ResponseEntity<?> register(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/register";
        restTemplate.setErrorHandler(new MyErrorHandler());
        response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
        System.out.println("message" + response.getBody().getMessage());
           if (!response.getBody().isSuccessfull()){
               throw new ApiException(response.getBody().getMessage());
           }
        return response;

        }





}
