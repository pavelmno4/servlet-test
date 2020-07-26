package ru.pkozlov.servlettest.controller;

import org.springframework.web.bind.annotation.*;
import ru.pkozlov.servlettest.entity.Role;
import ru.pkozlov.servlettest.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping
    public String addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @DeleteMapping("{id}")
    public String deleteRole(@PathVariable Long id) {
        return roleService.deleteById(id);
    }
}
