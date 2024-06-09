package ads.cip.repository;

import ads.cip.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, String> {
}