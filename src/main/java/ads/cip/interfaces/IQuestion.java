package ads.cip.interfaces;

import ads.cip.model.QuestionModel;

import java.util.List;
import java.util.Optional;

public interface IQuestion {
    List<QuestionModel> getAllQuestions();
    Optional<QuestionModel> getQuestionById(String id);
    QuestionModel saveQuestion(QuestionModel question);
    void deleteQuestion(String id);
    QuestionModel updateQuestion(String id, QuestionModel newQuestion);
}