package com.camp.cammvc.modules.users.controller;


import com.camp.cammvc.modules.places.entity.ChildPlace;
import com.camp.cammvc.modules.users.entity.AppUser;
import com.camp.cammvc.modules.users.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;

@Controller
@RequestMapping(path = {"/",""})
public class UserController {


    @Autowired
    private UserApiService userApiService;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/user/getUser/{username}")
    public String getByUsername(@PathVariable("username") String username,Model model){

        model.addAttribute("user",userApiService.getByUsername(username) );
        return "users/user";
    }


    @GetMapping("/user/allUser")
    public String getAllUsers(Model model){

        model.addAttribute("users",userApiService.getAllUsers());
        return "users/users";
    }



    @RequestMapping(path = {"/user/edit", "/user/edit/{id}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editUserById(Model model)
    {
        model.addAttribute("appUser", new AppUser());
        return "users/add-edit-user";
    }


    @RequestMapping(path = {"/user/register"},method = {RequestMethod.GET,RequestMethod.POST})
    public String showRegisterUser(Model model)
    {
        model.addAttribute("appUser", new AppUser());
        return "users/add-edit-user";
    }




    @RequestMapping(path="/user/registerUser",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult bindingResult,Model model)  {

        model.addAttribute("appUser",appUser);

        if (bindingResult.hasErrors()){
            return "users/add-edit-user";
        }
        userApiService.register(appUser) ;
        return "redirect:/user/register";
    }



    @RequestMapping(path = {"/"},method = {RequestMethod.GET})
    public String showLogin(Model model)
    {
        model.addAttribute("appUser", new AppUser());

        return "users/login";
    }


    @RequestMapping(path = {"/login"},method = {RequestMethod.GET})
    public String showmyLogin(Model model)
    {
        model.addAttribute("appUser", new AppUser());

        return "users/login";
    }

    @RequestMapping(path="/user/loginPage",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String loginPage( @ModelAttribute("appUser") AppUser appUser, Model model)  {

        model.addAttribute("appUser",appUser);
        userApiService.login(appUser);
        return "redirect:/user/allUser";

    }



    @RequestMapping(path = {"/logout"},method = {RequestMethod.GET,RequestMethod.POST})
    public String logout()
    {
        userApiService.logout();
        return "users/logout";
    }


}
