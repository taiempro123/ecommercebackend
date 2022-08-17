package com.tantai.dacnpm.service.User;

import com.tantai.dacnpm.exceptions.NotFoundException;
import com.tantai.dacnpm.entity.User;
import com.tantai.dacnpm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository repo;

    public List<User> getUsers () {
        return repo.findAll();
    }

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public void deleteUser (Long id) {
        repo.deleteById(id);
    }

    @Override
    public User add(User createDto) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(long id) {
        return repo.findById(id).orElseThrow(() ->
                new NotFoundException("User by id " + id + " was not found."));
    }

    @Override
    public void deleteById(long id) {

    }


    @Override
    public User getByUserName(String userName) {
        return null;
    }

    @Override
    public User findByEMail(String eMail) {
        return null;
    }

    @Override
    public void updateByUserName(long userId, String userName) {

    }
}
