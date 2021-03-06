package com.camp.cammvc.modules.places.controller;

import com.camp.cammvc.modules.users.entity.AppUser;
import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.modules.places.entity.Place;
import com.camp.cammvc.modules.places.service.ChildPlaceService;
import com.camp.cammvc.modules.places.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping( "/place")
public class ChildPlaceController {


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @Autowired
    private ChildPlaceService childPlaceService;

    @Autowired
    private PlaceService placeService;




    @RequestMapping(path={"/register"},method = {RequestMethod.POST},produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@Valid @ModelAttribute("childPlace") ChildPlace childPlace ,BindingResult bindingResult, Model model, Principal principal ) throws IllegalAccessException, IOException, InvocationTargetException {

        model.addAttribute("places",placeService.getAllPlaces());
        System.out.println("Has errors="+bindingResult.hasErrors()); // Output: Has errors=true
        if (bindingResult.hasErrors()){

            return "posts/add-edit-child";
        } else {
            childPlaceService.registerChildPlace(childPlace);
            return "redirect:/place/allPlace";
        }
    }



    @RequestMapping(path = {"/",""},method = {RequestMethod.GET})
    public String showRegister(Model model)
    {
        model.addAttribute("childPlace", new ChildPlace());
        model.addAttribute("places",placeService.getAllPlaces());

        return "posts/add-edit-child";
    }


    @RequestMapping(path={"/edit/{id}"},method ={RequestMethod.GET} )
    public String editplace(Model model,@PathVariable("id") long id){
        System.out.println(id);
        model.addAttribute("childPlace",childPlaceService.findChildPlaceById(id));
        model.addAttribute("places",placeService.getAllPlaces());

        return "posts/add-edit-child";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        childPlaceService.deleteById(id);
        return "redirect:/place/allPlace";
    }


    @RequestMapping(path = "/allPlace/{pageNo}",method = {RequestMethod.GET})
    public String getAllPlaces(Model model,@PathVariable (value = "pageNo") int pageNo) {

        int pageSize = 5;

        Page<ChildPlace> page = childPlaceService.getAllChildPlace(pageNo);
        List<ChildPlace> listChildPlace = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("allPlaces", listChildPlace);
        model.addAttribute("categories", placeService.getAllPlaces());

        return "posts/places";

        }





}
