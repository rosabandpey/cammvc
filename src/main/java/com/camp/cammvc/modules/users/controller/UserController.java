package com.camp.cammvc.modules.users.controller;


import com.camp.cammvc.modules.users.entity.AppUser;
import com.camp.cammvc.modules.users.service.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserApiService userApiService;


    @GetMapping("/getUser/{username}")
    public String getByUsername(@PathVariable("username") String username,Model model){

        model.addAttribute("user",userApiService.getByUsername(username) );
        return "users/user";
    }


    @GetMapping("/allUser")
    public String getAllUsers(Model model){

        model.addAttribute("users",userApiService.getAllUsers());
        return "users/users";
    }

  /*  @GetMapping("/add-edit-user")
    public String create(){


        return "add-edit-user";
    } */


    @RequestMapping(path = {"/edit", "/edit/{id}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editUserById(Model model,AppUser appUser)
    {
        model.addAttribute("appUser", appUser);
        return "users/add-edit-user";
    }



    @RequestMapping(path="/create",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(@ModelAttribute AppUser appUser)  {

        userApiService.register(appUser) ;
        return "redirect:/edit";
    }

    @GetMapping(path = {"/login"})
    public String login(Model model,AppUser appUser)
    {
        model.addAttribute("appUser", appUser);
        return "users/login";
    }

    @RequestMapping(path="/loginPage",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String loginPage(@ModelAttribute AppUser appUser)  {

        userApiService.login(appUser) ;
        return "redirect:/allUser";
    }


    @RequestMapping(path = {"/logout"},method = {RequestMethod.GET,RequestMethod.POST})
    public String logout()
    {
        userApiService.logout();
        return "users/logout";
    }


}