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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

@Controller
@RequestMapping( "/place")
public class ChildPlaceController {


    @Autowired
    private ChildPlaceService childPlaceService;

    @Autowired
    private PlaceService placeService;




    @RequestMapping(path={"/register"},method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@Valid @ModelAttribute("childPlace") ChildPlace childPlace ,Model model, Principal principal , BindingResult bindingResult) throws IllegalAccessException, IOException, InvocationTargetException {

        System.out.println("child name "+childPlace.getChildName());

        if (bindingResult.hasErrors()){
            //
           // model.addAttribute("childPlace", new ChildPlace());
            model.addAttribute("places",placeService.getAllPlaces());

            return "posts/add-edit-child";
        } else {
            System.out.println(childPlace.getMychildplace());
            childPlaceService.registerChildPlace(childPlace);
            return "redirect:/posts/add-edit-child";
        }
    }



    @RequestMapping(path = {"/register"},method = {RequestMethod.GET})
    public String showRegister(Model model)
    {

        model.addAttribute("childPlace", new ChildPlace());
        model.addAttribute("places",placeService.getAllPlaces());

        return "posts/add-edit-child";
    }





}
