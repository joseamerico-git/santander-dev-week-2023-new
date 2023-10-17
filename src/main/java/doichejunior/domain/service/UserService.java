package doichejunior.domain.service;

import doichejunior.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
