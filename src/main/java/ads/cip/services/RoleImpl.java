package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IRole;
import ads.cip.model.RoleModel;
import ads.cip.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleImpl implements IRole {

    private final RoleRepository roleRepository;
    private static final String message = "Role not found";

    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleModel> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleModel> getRoleById(String role) {
        if(!roleRepository.existsById(role)){
            throw new NotFoundException(message);
        }
        return roleRepository.findById(role);
    }

    @Override
    @Transactional
    public RoleModel saveRole(RoleModel role) {
        if(roleRepository.existsById(role.getRoleId())){
            throw new AlreadyExistsException("Role already exists");
        }
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(String role) {
        if(!roleRepository.existsById(role)){
            throw new NotFoundException(message);
        }
        roleRepository.deleteById(role);
    }

    @Override
    @Transactional
    public RoleModel updateRole(String id, RoleModel newRole) {
        Optional<RoleModel> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            RoleModel existingRole = optionalRole.get();
            existingRole.setRoleName(newRole.getRoleName());
            existingRole.setRoleDescription(newRole.getRoleDescription());
            return roleRepository.save(existingRole);
        } else {
            throw new NotFoundException(message);
        }
    }
}