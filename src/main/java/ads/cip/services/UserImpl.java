package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IUser;
import ads.cip.model.UserModel;
import ads.cip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserImpl implements IUser {

    private final UserRepository userRepository;
    private static final String message = "User not found with id: ";

    @Autowired
    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUserById(UUID id) {
        if(!userRepository.existsById(id)){
            throw new NotFoundException(message + id);
        }
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public UserModel saveUser(UserModel user) {
        if(userRepository.existsById(user.getUserId())){
            throw new AlreadyExistsException("User already exists" + user.getUserId());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(UUID id) {
        if(!userRepository.existsById(id)){
            throw new NotFoundException(message + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
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
        } else {
            throw new NotFoundException(message + id);
        }
    }
}