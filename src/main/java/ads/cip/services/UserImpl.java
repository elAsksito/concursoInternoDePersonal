package ads.cip.services;

import ads.cip.interfaces.IUser;
import ads.cip.model.UserModel;
import ads.cip.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserImpl implements IUser {

    private UserRepository userRepository;

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel updateUser(UUID id, UserModel newUser) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            existingUser.setUserFirstName(newUser.getUserFirstName());
            existingUser.setUserLastName(newUser.getUserLastName());
            existingUser.setUserDni(newUser.getUserDni());
            existingUser.setUserRegistrationDate(newUser.getUserRegistrationDate());
            existingUser.setUserGender(newUser.getUserGender());
            existingUser.setUserAdrress(newUser.getUserAdrress());
            existingUser.setUserEmail(newUser.getUserEmail());
            existingUser.setUserPhone(newUser.getUserPhone());
            existingUser.setUserPassword(newUser.getUserPassword());
            existingUser.setUserCv(newUser.getUserCv());
            existingUser.setPosition(newUser.getPosition());
            existingUser.setRole(newUser.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }
}