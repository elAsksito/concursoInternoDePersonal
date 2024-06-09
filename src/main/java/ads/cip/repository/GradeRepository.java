package ads.cip.repository;

import ads.cip.model.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeModel, String> {
}