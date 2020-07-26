package ru.pkozlov.servlettest.service;

import org.springframework.stereotype.Service;
import ru.pkozlov.servlettest.entity.Role;
import ru.pkozlov.servlettest.repository.RoleRepo;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> findAll() {
        return (List<Role>) roleRepo.findAll();
    }

    public String addRole(Role newRole) {
        String answer = "";
        if(newRole.getId() != null) {
            Role role = roleRepo.findAllById(newRole.getId());
            role.setRole(newRole.getRole());
            roleRepo.save(role);
            answer = "You have successfully update the role";
        } else {
            roleRepo.save(newRole);
            answer = "You have successfully create the role";
        }
        return answer;
    }

    public Role findById(Long id) {
        return roleRepo.findAllById(id);
    }

    public String deleteById(Long id) {
        roleRepo.deleteById(id);
        return "You have successfully deleted the role";
    }
}
