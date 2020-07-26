package ru.pkozlov.servlettest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pkozlov.servlettest.entity.Role;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findAllById(Long id);
}
