package ads.cip.repository;

import ads.cip.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel, String> {
}