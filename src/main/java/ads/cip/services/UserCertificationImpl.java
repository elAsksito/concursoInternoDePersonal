package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IUserCertification;
import ads.cip.model.UserCertificationId;
import ads.cip.model.UserCertificationModel;
import ads.cip.repository.UserCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserCertificationImpl implements IUserCertification {

    private final UserCertificationRepository userCertificationRepository;
    private static final String message = "User Certification not found";

    @Autowired
    public UserCertificationImpl(UserCertificationRepository userCertificationRepository) {
        this.userCertificationRepository = userCertificationRepository;
    }

    @Override
    public List<UserCertificationModel> getAllUserCertification() {
        return userCertificationRepository.findAll();
    }

    @Override
    public Optional<UserCertificationModel> getUserCertificationById(UserCertificationId id) {
        if(!userCertificationRepository.existsById(id)){
            throw new NotFoundException(message);
        }
        return userCertificationRepository.findById(id);
    }

    @Override
    @Transactional
    public UserCertificationModel createUserCertification(UserCertificationId id, UserCertificationModel userCertification) {
        if(userCertificationRepository.existsById(id)){
            throw new AlreadyExistsException("User Certification already exists");
        }
        return userCertificationRepository.save(userCertification);
    }

    @Override
    @Transactional
    public void deleteUserCertification(UserCertificationId  id) {
        if(!userCertificationRepository.existsById(id)){
            throw new NotFoundException(message);
        }
        userCertificationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserCertificationModel updateUserCertification(UserCertificationId id, UserCertificationModel newUserCertification) {
        Optional<UserCertificationModel> existingUserCertificationOptional = userCertificationRepository.findById(id);
        if (existingUserCertificationOptional.isPresent()) {
            UserCertificationModel existingUserCertification = existingUserCertificationOptional.get();

            userCertificationRepository.delete(existingUserCertification);

            existingUserCertification.setUserModel(newUserCertification.getUserModel());
            existingUserCertification.setCertificationModel(newUserCertification.getCertificationModel());

            return userCertificationRepository.save(existingUserCertification);
        } else {
            throw new NotFoundException(message);
        }
    }
}