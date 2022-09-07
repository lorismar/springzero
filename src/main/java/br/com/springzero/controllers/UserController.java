package br.com.springzero.controllers;

import br.com.springzero.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();


    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {

        Optional<User> userfind = users.stream().filter(user-> user.getId() == id).findFirst();

//        System.out.println("O id" + id);
//        User user = new User();
//        user.setId(3L);
//        user.setName("Lorismar Lima rosendo");
//        user.setUsername("loriss");
        if (userfind.isPresent()) {
            return userfind.get();
        }
        return null;
    }



    @PostMapping("save")
    public User user(@RequestBody User user){
         users.add(user);
        return  user;
    }

    @GetMapping("lista")
    public List<User> lista(){

        return users;
    }





}
