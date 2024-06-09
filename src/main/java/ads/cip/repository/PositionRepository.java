package ads.cip.repository;

import ads.cip.model.PositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionModel, String> {
}