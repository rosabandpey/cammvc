package com.camp.cammvc.controller;

import com.camp.cammvc.entity.ChildPlace;
import com.camp.cammvc.service.ChildPlaceService;
import com.camp.cammvc.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( "/place")
public class ChildPlaceController {


    @Autowired
    private ChildPlaceService childPlaceService;

    @Autowired
    private PlaceService placeService;
    String placeName;
    String username;


    @RequestMapping(path="/savePlace",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(Model model, ChildPlace childPlace)  {
        placeName="MountainCamp";
        username="ghadimi@gmail.com";
        childPlaceService.registerChildPlace(childPlace,username,placeName) ;
        return "redirect:/edit";
    }


    @RequestMapping(path = {"/edit", "/edit/{id}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editUserById(Model model,ChildPlace childPlace)
    {
        model.addAttribute("childPlace", childPlace);
       // model2.addAttribute("place",placeService.getAllPlaces());

        //model.addAttribute("place",places);
        return "add-edit-child";
    }





}
