package ads.cip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name="Role")
@Data
public class RoleModel {

    @Id
    @Column(name = "role_id", length = 7)
    private String roleId;

    @Column(name = "role_name", length = 150)
    private String roleName;

    @Column(name = "role_description", length = 500)
    private String roleDescription;
}