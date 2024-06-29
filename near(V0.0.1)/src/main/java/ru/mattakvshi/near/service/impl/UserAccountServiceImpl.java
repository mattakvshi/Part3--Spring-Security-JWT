package ru.mattakvshi.near.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mattakvshi.near.dao.repository.auth.UserAccountRepository;
import ru.mattakvshi.near.entity.auth.UserAccount;
import ru.mattakvshi.near.service.UserAccountService;

import java.util.UUID;


@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder; //Позволяет шифровать пороли и записывать в базу в зашифрованном виде

    public UserAccount saveUser(UserAccount userAccount) {;
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccountRepository.save(userAccount);
    }

    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email);
    }

    public UserAccount findByEmailAndPassword(String email, String password) {
        UserAccount userAccount = findByEmail(email);
        if (userAccount != null) {
            if (passwordEncoder.matches(password, userAccount.getPassword())) {
                return userAccount;
            }
        }
        return null;
    }

    @Override
    public UserAccount findById(UUID id) {
        return userAccountRepository.findById(id).orElse(null);
    }
}
