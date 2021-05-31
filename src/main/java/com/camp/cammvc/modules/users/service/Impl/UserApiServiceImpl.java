package com.camp.cammvc.modules.users.service.Impl;

import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.modules.users.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.modules.users.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service

public class UserApiServiceImpl implements UserApiService {


    @Autowired
    ResponseToken responseToken;

    @Autowired
    private RestTemplate restTemplate;


    ResponseEntity<ResponseApi> response;

    public List<AppUser> getByUsername(String username){

            final String uri = "http://localhost:8085/api/authenticate/getByUsername/{username}";
            restTemplate.setErrorHandler(new MyErrorHandler());
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(responseToken.getToken());
            HttpEntity request = new HttpEntity(headers);
            response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,params);
            List<AppUser> users = (response.getBody().getData());

            if (!response.getBody().isSuccessfull() ){
                System.out.println( "myUser   "+response.getBody().getMessage().toString());
             //      if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
              //          throw new NotFoundException(response.getBody().getMessage());
              //     }
            //    throw new ApiException(response.getBody().getMessage());

               } else {
                System.out.println( "myUser  "+"User Retrieved Successfully");

            }
            return users;


    }




    public List<AppUser> getAllUsers(){

        final String uri="http://localhost:8085/api/authenticate/userList";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class);
        List<AppUser> users=(response.getBody().getData());

        if (!response.getBody().isSuccessfull()){
            System.out.println( "AllUser   "+response.getBody().getMessage().toString());
          //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
          //      throw new NotFoundException(response.getBody().getMessage());
          //  }
           // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "AllUser "+" User List Retrieved Successfully");

        }
        return users;
    }

    public  ResponseEntity<?> login(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/login";
        restTemplate.setErrorHandler(new MyErrorHandler());
        response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
        if (response.getStatusCodeValue()==200){

            HttpHeaders headers= response.getHeaders();
            String token= headers.get("Authorization").toString();
            System.out.println( "login   "+token);
            if (headers.containsKey("Authorization")) {

                System.out.println( "login   "+"header get Successfully");
                System.out.println( "login   "+token);

                responseToken.setToken(token);
                responseToken.setUsername(appUser.getUsername());
            }

            System.out.println( "login   "+"login Successfully");


        }
        else {
            System.out.println( "login   "+response.getBody().toString());
          //  throw new ApiException(response.getBody().toString());
        }
        return response;

    }


    public  String logout()  {

        responseToken.setToken("");
        System.out.println( " logout  "+responseToken.getToken());
        return " logout Successfully";
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return null;
    }

    @Override
    public AppUser findUserById(long id) {

        final String uri = "http://localhost:8085/api/childPlace/findUserById/{id}";
        restTemplate.setErrorHandler(new MyErrorHandler());
        // Map<String, Long> params = new HashMap<String, Long>();
        // params.put("id",id);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<AppUser> response =  restTemplate.exchange(uri, HttpMethod.GET, request, AppUser.class,id);
        AppUser user = (response.getBody());
        return user;

    }

    @Override
    public ResponseEntity<?> deleteUserById(long id) {

        final String uri="http://localhost:8085/api/authenticate/deleteUser/{id}";
        restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,id);


        if (!response.getBody().isSuccessfull()){
            System.out.println( "User   "+response.getBody().getMessage().toString());
            //  if (response.getStatusCode()==HttpStatus.NOT_FOUND) {
            //      throw new NotFoundException(response.getBody().getMessage());
            //  }
            // throw new ApiException(response.getBody().getMessage());

        }
        else {
            System.out.println( "User  "+" User Delete Successfully");

        }
        return response;

    }

    public  ResponseEntity<?> register(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/register";
        restTemplate.setErrorHandler(new MyErrorHandler());
        response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
        if (!response.getBody().isSuccessfull()){

               System.out.println( "register   "+response.getBody().getMessage().toString());
          //    throw new ApiException(response.getBody().getMessage());
           }
        else {
            System.out.println( "register   "+"User Registered Successfully");
        }
        return response;

        }





}
