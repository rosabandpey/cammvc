package com.camp.cammvc.modules.places.controller;

import com.camp.cammvc.modules.users.entity.AppUser;
import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.modules.places.entity.Place;
import com.camp.cammvc.modules.places.service.ChildPlaceService;
import com.camp.cammvc.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping( "/place")
public class ChildPlaceController {


    @Autowired
    private ChildPlaceService childPlaceService;

    @Autowired
    private PlaceService placeService;



   // Place place;
   // String placeName;
    //String username;


    @RequestMapping(path={"/savePlace"},method = {RequestMethod.POST,RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(@ModelAttribute("childPlace")ChildPlace childPlace ,Principal principal ) {
       // placeName=place.getPlaceName();
       // System.out.println("placeName"+placeName);
        AppUser appUser=new AppUser();
        appUser.setId(3);
        childPlace.setUserChildPlace(appUser);
       // place.setId(pId);
        //System.out.println(place.getId());
        //childPlace.setMychildplace(place);
        childPlaceService.registerChildPlace(childPlace) ;
        return "redirect:/edit";
    }



    @RequestMapping(path = {"/edit", "/edit/{id}"},method = {RequestMethod.GET})
    public String editUserById(Model model)
    {

        model.addAttribute("childPlace", new ChildPlace());
        model.addAttribute("places",placeService.getAllPlaces());
       // model.addAttribute("places",new Place());
        //model.addAttribute("place",places);
        return "posts/add-edit-child";
    }





}
