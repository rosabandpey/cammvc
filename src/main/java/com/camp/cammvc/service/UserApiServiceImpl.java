package com.camp.cammvc.service;

import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserApiServiceImpl {





    @Autowired
    private RestTemplate restTemplate;

    public ResponseApi getByUsername(String username){
        final String uri="http://localhost:8085/user/getByUsername/{username}";
        Map<String,String> params=new HashMap<String,String>();
        params.put("username",username);
        ResponseApi responseApi=restTemplate.getForObject(uri,ResponseApi.class,params);
        return responseApi;
    }


    /*public ResponseApi register(AppUser appUser){
        final String uri="http://localhost:8085/user/register";
        ResponseApi responseApi=restTemplate.postForObject(uri,ResponseApi.class,appUser);
        return
    } */

}
