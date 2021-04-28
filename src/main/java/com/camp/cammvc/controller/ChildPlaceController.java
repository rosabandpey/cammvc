package com.camp.cammvc.controller;

import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ChildPlace;
import com.camp.cammvc.entity.Place;
import com.camp.cammvc.service.ChildPlaceService;
import com.camp.cammvc.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   // String placeName;
    //String username;


    @RequestMapping(path="/savePlace",method = {RequestMethod.POST,RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(Model model, ChildPlace childPlace, Place place, AppUser appUser)  {

       // placeName=place.getPlaceName();
       // System.out.println("placeName"+placeName);
        appUser.setId(3);
        childPlace.setUserChildPlace(appUser);
        place.setId(1);
        childPlace.setMychildplace(place);
        childPlaceService.registerChildPlace(childPlace) ;
        return "redirect:/edit";
    }


    @RequestMapping(path = {"/edit", "/edit/{id}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editUserById(Model model, Model model2,ChildPlace childPlace)
    {

        model.addAttribute("childPlace", childPlace);
        model2.addAttribute("place",placeService.getAllPlaces());

        //model.addAttribute("place",places);
        return "add-edit-child";
    }





}
