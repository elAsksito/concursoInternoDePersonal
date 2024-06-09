package ads.cip.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class UserCertificationId implements Serializable {
    private UUID user;
    private String certification;
}