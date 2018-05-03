package net.blog.base.controller;

import net.blog.base.entity.User;
import net.blog.base.repository.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by drsnkrt on 15.03.2018.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;


    @GetMapping(value = "/allusers")
    public Iterable<User> getAll() {
        return service.getAllUsers();
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody final User user) {
        service.saveOrUpdate(user);
    }

    @GetMapping(value = "/{userId}")
    public User getById(@PathVariable final int userId) {
        return service.getUserById(userId);
    }
}
