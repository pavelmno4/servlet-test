package ru.pkozlov.servlettest.service;

import org.springframework.stereotype.Service;
import ru.pkozlov.servlettest.entity.Role;
import ru.pkozlov.servlettest.entity.User;
import ru.pkozlov.servlettest.repository.UserRepo;

import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

    public String addUser(User newUser) {
        String answer = "";
        if(newUser.getId() != null) {
            User user = userRepo.findAllById(newUser.getId());
            user.setLogin(newUser.getLogin());
            user.setName(newUser.getName());
            user.setPassword(newUser.getPassword());
            userRepo.save(user);
            answer = "You have successfully update the user";
        } else {
            userRepo.save(newUser);
            answer = "You have successfully create the user";
        }
        return answer;
    }

    public User findById(Long id) {
        return userRepo.findAllById(id);
    }

    public String deleteById(Long id) {
        userRepo.deleteById(id);
        return "You have successfully deleted the user";
    }

    public Set<Role> getRoles(Long id) {
        return userRepo.findAllById(id).getRoles();
    }

    public String addRole(Long id, Role role) {
        User user = userRepo.findAllById(id);
        user.getRoles().add(role);
        userRepo.save(user);
        return "You have successfully added the role";
    }
}
