package ru.mattakvshi.near.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mattakvshi.near.dao.UserDAO;
import ru.mattakvshi.near.dao.repository.UserRepository;
import ru.mattakvshi.near.entity.User;

import java.util.UUID;


@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UUID saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
