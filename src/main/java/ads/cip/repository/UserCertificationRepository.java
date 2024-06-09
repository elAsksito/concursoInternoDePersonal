package ads.cip.repository;

import ads.cip.model.UserCertificationId;
import ads.cip.model.UserCertificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCertificationRepository extends JpaRepository<UserCertificationModel, UserCertificationId> {
}