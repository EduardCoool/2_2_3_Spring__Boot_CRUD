package spring.service;

import spring.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void saveUser(User user);

    void deleteUserById(long id);

    User getById(Long id);
}
