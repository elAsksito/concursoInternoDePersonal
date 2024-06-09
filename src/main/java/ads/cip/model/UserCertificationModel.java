package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserCertifications")
@Data
@IdClass(UserCertificationId.class)
public class UserCertificationModel {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    private UserModel userModel;

    @Id
    @ManyToOne
    @JoinColumn(name = "certification_id_fk", referencedColumnName = "certification_id")
    private CertificationModel certificationModel;
}