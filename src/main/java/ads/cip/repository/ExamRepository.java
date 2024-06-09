package ads.cip.repository;

import ads.cip.model.ExamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamModel, String> {
}