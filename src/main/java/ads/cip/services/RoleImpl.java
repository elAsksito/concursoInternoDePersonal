package ads.cip.services;

import ads.cip.interfaces.IRole;
import ads.cip.model.RoleModel;
import ads.cip.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleImpl implements IRole {

    private RoleRepository roleRepository;

    @Override
    public List<RoleModel> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleModel> getRoleById(String role) {
        return roleRepository.findById(role);
    }

    @Override
    public RoleModel saveRole(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(String role) {
        roleRepository.deleteById(role);
    }

    @Override
    public RoleModel updateRole(String id, RoleModel newRole) {
        Optional<RoleModel> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            RoleModel existingRole = optionalRole.get();
            existingRole.setRoleName(newRole.getRoleName());
            existingRole.setRoleDescription(newRole.getRoleDescription());
            return roleRepository.save(existingRole);
        }
        return null;
    }
}