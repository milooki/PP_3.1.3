package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class Init {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        Role role = new Role("ROLE_USER");
        roleRepository.save(role);

        Role role1 = new Role("ROLE_ADMIN");
        roleRepository.save(role1);

        User user = new User();
        user.setName("user");
        user.setLastName("test");
        user.setAge(15L);
        user.setPassword("100");
        user.setRoles(Collections.singletonList(role));
        userService.add(user);

        User user1 = new User();
        user1.setName("admin");
        user1.setLastName("test");
        user1.setAge(20L);
        user1.setPassword("100");
        user1.setRoles(Collections.singletonList(role1));
        userService.add(user1);
    }
}
