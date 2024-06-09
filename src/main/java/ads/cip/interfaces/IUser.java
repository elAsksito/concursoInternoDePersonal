package ads.cip.interfaces;

import ads.cip.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUser {
    List<UserModel> getAllUsers();
    Optional<UserModel> getUserById(UUID id);
    UserModel saveUser(UserModel user);
    void deleteUser(UUID id);
    UserModel updateUser(UUID id, UserModel newUser);
}