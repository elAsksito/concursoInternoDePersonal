package ads.cip.services;

import ads.cip.interfaces.IUserCertification;
import ads.cip.model.UserCertificationId;
import ads.cip.model.UserCertificationModel;
import ads.cip.repository.UserCertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCertificationImpl implements IUserCertification {

    private UserCertificationRepository userCertificationRepository;

    @Override
    public List<UserCertificationModel> getAllUserCertification() {
        return userCertificationRepository.findAll();
    }

    @Override
    public Optional<UserCertificationModel> getUserCertificationById(UserCertificationId id) {
        return userCertificationRepository.findById(id);
    }

    @Override
    public UserCertificationModel createUserCertification(UserCertificationModel userCertification) {
        return userCertificationRepository.save(userCertification);
    }

    @Override
    public void deleteUserCertification(UserCertificationId  id) {
        userCertificationRepository.deleteById(id);
    }

    @Override
    public UserCertificationModel updateUserCertification(UserCertificationId id, UserCertificationModel newUserCertification) {
        Optional<UserCertificationModel> existingUserCertificationOptional = userCertificationRepository.findById(id);
        if (existingUserCertificationOptional.isPresent()) {
            UserCertificationModel existingUserCertification = existingUserCertificationOptional.get();

            userCertificationRepository.delete(existingUserCertification);

            existingUserCertification.setUserModel(newUserCertification.getUserModel());
            existingUserCertification.setCertificationModel(newUserCertification.getCertificationModel());

            return userCertificationRepository.save(existingUserCertification);
        }
        return null;
    }
}