package doichejunior.service.impl;

import doichejunior.domain.model.User;
import doichejunior.domain.repository.UserRepository;
import doichejunior.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
      return user.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This User ID already exists.");
        }

        return userRepository.save(userToCreate);
    }

}
