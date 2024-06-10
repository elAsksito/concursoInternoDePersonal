package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.ICertification;
import ads.cip.model.CertificationModel;
import ads.cip.repository.CertificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationImpl implements ICertification {

    private final CertificationRepository certificationRepository;
    private static final String message = "Certification not found with id: ";

    public CertificationImpl(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    @Override
    public List<CertificationModel> getAllCertifications() {
        return certificationRepository.findAll();
    }

    @Override
    public Optional<CertificationModel> getCertificationById(String certificationId) {
        if (!certificationRepository.existsById(certificationId)) {
            throw new NotFoundException(message + certificationId);
        }
        return certificationRepository.findById(certificationId);
    }

    @Override
    @Transactional
    public CertificationModel createCertification(CertificationModel certification) {
        if(certificationRepository.existsById(certification.getCertificationId())){
            throw new AlreadyExistsException("Certification already exists with id: " + certification.getCertificationId());
        }
        return certificationRepository.save(certification);
    }

    @Override
    @Transactional
    public void deleteCertification(String certificationId) {
        if(!certificationRepository.existsById(certificationId)){
            throw new NotFoundException(message + certificationId);
        }
        certificationRepository.deleteById(certificationId);
    }

    @Override
    @Transactional
    public CertificationModel updateCertification(String id, CertificationModel newCertification) {
        Optional<CertificationModel> optionalCertification = certificationRepository.findById(id);

        if (optionalCertification.isPresent()) {
            CertificationModel existingCertification = optionalCertification.get();
            existingCertification.setCertificationName(newCertification.getCertificationName());
            existingCertification.setCertificationFile(newCertification.getCertificationFile());
            return certificationRepository.save(existingCertification);
        } else{
            throw new NotFoundException(message + id);
        }
    }
}