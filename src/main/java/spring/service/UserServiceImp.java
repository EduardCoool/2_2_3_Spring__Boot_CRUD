package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserRepository;
import spring.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImp() {
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        User user;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException(
                    "User not found for id : " + id);
        return user;
    }
}



