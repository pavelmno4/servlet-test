package ru.pkozlov.servlettest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pkozlov.servlettest.entity.Role;
import ru.pkozlov.servlettest.entity.User;
import ru.pkozlov.servlettest.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public String addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @GetMapping("{id}/roles")
    public Set<Role> getRoles(@PathVariable Long id) {
        return userService.getRoles(id);
    }

    @PostMapping("{id}/roles")
    public String addRole(@PathVariable Long id, @RequestBody Role role) {
        return userService.addRole(id, role);
    }
}
