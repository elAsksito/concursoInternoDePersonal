package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "User")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "user_first_name", length = 350)
    private String userFirstName;

    @Column(name = "user_last_name", length = 350)
    private String userLastName;

    @Column(name = "user_dni", length = 8, unique = true, nullable = false)
    private String userDni;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_registration_date")
    private Date userRegistrationDate;

    @Column(name = "user_gender", length = 10)
    private String userGender;

    @Column(name = "user_address", length = 200)
    private String userAdrress;

    @Column(name = "user_email", length = 250)
    private String userEmail;

    @Column(name = "user_phone", length = 9)
    private String userPhone;

    @Column(name = "user_password", length = 500, nullable = false)
    private String userPassword;

    @Lob
    @Column(name = "user_cv")
    private byte[] userCv;

    @ManyToOne
    @JoinColumn(name = "position_id_fk", referencedColumnName = "position_id")
    private PositionModel position;

    @ManyToOne
    @JoinColumn(name = "role_id_fk", referencedColumnName = "role_id")
    private RoleModel role;
}