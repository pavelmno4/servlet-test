package ru.pkozlov.servlettest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pkozlov.servlettest.entity.User;

public interface UserRepo extends CrudRepository<User,Long> {
    User findAllById(Long id);
}
