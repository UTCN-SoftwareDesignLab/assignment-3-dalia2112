package clinic.service.user;

import clinic.model.User;
import clinic.model.validation.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    Notification<Boolean> deleteUser(long id);
    User findById(long id);
    User findByUsername(String username);
    Notification<Boolean> registerUser(String username, String password, String role);
    Notification<Boolean> login(String username, String password);
    Notification<Boolean> updateUser(long id, String name, String password, String role);
}
