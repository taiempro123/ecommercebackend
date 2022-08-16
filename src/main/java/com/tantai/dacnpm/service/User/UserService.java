package com.tantai.dacnpm.service.User;


import com.tantai.dacnpm.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    User add(User createDto);
    List<User> getAll();
    User getById(long id);
    void deleteById(long id);
    User getByUserName(String userName);
    User findByEMail(String eMail);
    void updateByUserName(long userId, String userName);
}
