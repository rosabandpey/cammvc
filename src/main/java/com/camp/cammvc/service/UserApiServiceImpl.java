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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class UserApiServiceImpl {





    @Autowired
    private RestTemplate restTemplate;


    AppUser appUser;
    ResponseEntity<ResponseApi> response;

    public List<AppUser> getByUsername(String username){

            final String uri = "http://localhost:8085/api/authenticate/getByUsername/{username}";
           // URI targetURL= UriComponentsBuilder.fromUriString(uri)
                //    .queryParam("username", username)
               //     .build()
               //     .encode()
               //     .toUri();
       // System.out.println( "URL   "+targetURL);
           // restTemplate.setErrorHandler(new MyErrorHandler());
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            response = restTemplate.getForEntity(uri, ResponseApi.class,params);
            List<AppUser> users=(response.getBody().getData());
            if (!response.getBody().isSuccessfull()){
               // ResponseApi responseApi=new ResponseApi(false,response.getBody().getMessage(),new Date().toString(),response.getBody().getData());
                System.out.println( "User   "+response.getBody().getMessage().toString());
               } else {
                System.out.println( "User  "+"User Retrieved Successfully");

                return users;
            }
            return users;


    }


    public List<AppUser> getAllUsers(){

        final String uri="http://localhost:8085/api/authenticate/userList";
        response=restTemplate.getForEntity(uri, ResponseApi.class);
        List<AppUser> users=(response.getBody().getData());
        //List<AppUser> users=Arrays.asList(restTemplate.getForObject(uri, AppUser.class));
        // Arrays.asList(restTemplate.getForObject(uri, AppUser.class));
        //AppUser[] users=  restTemplate.getForObject(uri, AppUser[].class());
        //List list=Arrays.asList(users);
        //List<AppUser> users= (AppUser) response.getBody().getData();
        if (!response.getBody().isSuccessfull()){
            System.out.println( "AllUser   "+response.getBody().getMessage().toString());
        }
        else {
            System.out.println( "AllUser "+" User List Retrieved Successfully");

            return users;
        }
        return users;
    }




    public  ResponseEntity<?> register(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/register";
        restTemplate.setErrorHandler(new MyErrorHandler());
        response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
        if (!response.getBody().isSuccessfull()){


               System.out.println( "register   "+response.getBody().getMessage().toString());

           }
        else {
            System.out.println( "register   "+"User Registered Successfully");
        }
        return response;

        }





}
