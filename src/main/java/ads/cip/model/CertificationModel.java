package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Certifications")
@Data
public class CertificationModel {

    @Id
    @Column(name = "certification_id", length = 7)
    private String certificationId;

    @Column(name = "certification_name", length = 100, nullable = false)
    private String certificationName;

    @Lob
    @Column(name = "certification_file")
    private byte[] certificationFile;
}