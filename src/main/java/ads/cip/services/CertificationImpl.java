package ads.cip.services;

import ads.cip.interfaces.ICertification;
import ads.cip.model.CertificationModel;
import ads.cip.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationImpl implements ICertification {

    private CertificationRepository certificationRepository;

    @Override
    public List<CertificationModel> getAllCertifications() {
        return certificationRepository.findAll();
    }

    @Override
    public Optional<CertificationModel> getCertificationById(String certificationId) {
        return certificationRepository.findById(certificationId);
    }

    @Override
    public CertificationModel createCertification(CertificationModel certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public void deleteCertification(String certificationId) {
        certificationRepository.deleteById(certificationId);
    }

    @Override
    public CertificationModel updateCertification(String id, CertificationModel newCertification) {
        Optional<CertificationModel> optionalCertification = certificationRepository.findById(id);
        if (optionalCertification.isPresent()) {
            CertificationModel existingCertification = optionalCertification.get();
            existingCertification.setCertificationName(newCertification.getCertificationName());
            existingCertification.setCertificationFile(newCertification.getCertificationFile());
            return certificationRepository.save(existingCertification);
        }
        return null;
    }
}