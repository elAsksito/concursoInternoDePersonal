package ads.cip.interfaces;

import ads.cip.model.RoleModel;

import java.util.List;
import java.util.Optional;

public interface IRole {
    List<RoleModel> getAllRoles();
    Optional<RoleModel> getRoleById(String role);
    RoleModel saveRole(RoleModel role);
    void deleteRole(String role);
    RoleModel updateRole(String id, RoleModel newRole);
}