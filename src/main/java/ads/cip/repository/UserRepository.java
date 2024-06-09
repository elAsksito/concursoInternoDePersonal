package ads.cip.repository;

import ads.cip.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}