package ads.cip.interfaces;

import ads.cip.model.CertificationModel;

import java.util.List;
import java.util.Optional;

public interface ICertification {
    List<CertificationModel> getAllCertifications();
    Optional<CertificationModel> getCertificationById(String certificationId);
    CertificationModel createCertification(CertificationModel certification);
    void deleteCertification(String certificationId);
    CertificationModel updateCertification(String id, CertificationModel newCertification);
}