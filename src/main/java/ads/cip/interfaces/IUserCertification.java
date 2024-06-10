package ads.cip.interfaces;

import ads.cip.model.UserCertificationId;
import ads.cip.model.UserCertificationModel;

import java.util.List;
import java.util.Optional;

public interface IUserCertification {
    List<UserCertificationModel> getAllUserCertification();
    Optional<UserCertificationModel> getUserCertificationById(UserCertificationId id);
    UserCertificationModel createUserCertification(UserCertificationId id, UserCertificationModel userCertification);
    void deleteUserCertification(UserCertificationId id);
    UserCertificationModel updateUserCertification(UserCertificationId id, UserCertificationModel newUserCertification);
}