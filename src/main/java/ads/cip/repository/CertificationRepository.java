package ads.cip.repository;

import ads.cip.model.CertificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<CertificationModel, String> {
}
