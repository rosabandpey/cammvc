package com.camp.cammvc.service;

import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.exception.MyErrorHandler;
import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.exception.ApiException;
import com.camp.cammvc.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class UserApiServiceImpl implements UserApiService{


    @Autowired
    ResponseToken responseToken;

    @Autowired
    private RestTemplate restTemplate;


    ResponseEntity<ResponseApi> response;

    public List<AppUser> getByUsername(String username){

            final String uri = "http://localhost:8085/api/authenticate/getByUsername/{username}";
            //restTemplate.setErrorHandler(new MyErrorHandler());
            Map<String, String> params = new HashMap<String, String>();
            params.put("username", username);
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(responseToken.getToken());
            HttpEntity request = new HttpEntity(headers);
            response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class,params);
            List<AppUser> users = (response.getBody().getData());

            if (!response.getBody().isSuccessfull()){
                System.out.println( "myUser   "+response.getBody().getMessage().toString());
               } else {
                System.out.println( "myUser  "+"User Retrieved Successfully");

                return users;
            }
            return users;


    }




    public List<AppUser> getAllUsers(){

        final String uri="http://localhost:8085/api/authenticate/userList";
        //restTemplate.setErrorHandler(new MyErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(responseToken.getToken());
        HttpEntity request = new HttpEntity(headers);
        response =  restTemplate.exchange(uri, HttpMethod.GET, request, ResponseApi.class);
        List<AppUser> users=(response.getBody().getData());

        if (!response.getBody().isSuccessfull()){
            System.out.println( "AllUser   "+response.getBody().getMessage().toString());

        }
        else {
            System.out.println( "AllUser "+" User List Retrieved Successfully");

            return users;
        }
        return users;
    }

    public  ResponseEntity<?> login(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/login";
       // restTemplate.setErrorHandler(new MyErrorHandler());
        response = restTemplate.postForEntity(uri, appUser, ResponseApi.class);
        if (response.getStatusCodeValue()==200){

            HttpHeaders headers= response.getHeaders();
            String token= headers.get("Authorization").toString();
            System.out.println( "login   "+token);
            if (headers.containsKey("Authorization")) {

                System.out.println( "login   "+"header get Successfully");
                System.out.println( "login   "+token);

                responseToken.setToken(token);
            }

            System.out.println( "login   "+"login Successfully");


        }
        else {
            System.out.println( "login   "+response.getBody().toString());
        }
        return response;

    }


    public  String logout()  {

        responseToken.setToken("");
        System.out.println( " logout  "+responseToken.getToken());
        return " logout Successfully";
    }

    public  ResponseEntity<?> register(AppUser appUser)  {

        final String uri = "http://localhost:8085/api/authenticate/register";
       // restTemplate.setErrorHandler(new MyErrorHandler());
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
