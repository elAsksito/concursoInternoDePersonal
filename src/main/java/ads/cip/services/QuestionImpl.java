package ads.cip.services;

import ads.cip.interfaces.IQuestion;
import ads.cip.model.QuestionModel;
import ads.cip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionImpl implements IQuestion {

    private QuestionRepository questionRepository;

    @Override
    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<QuestionModel> getQuestionById(String id) {
        return questionRepository.findById(id);
    }

    @Override
    public QuestionModel saveQuestion(QuestionModel question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionModel updateQuestion(String id, QuestionModel newQuestion) {
        Optional<QuestionModel> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            QuestionModel existingQuestion = optionalQuestion.get();
            existingQuestion.setQuestionStatement(newQuestion.getQuestionStatement());
            existingQuestion.setExamModel(newQuestion.getExamModel());
            return questionRepository.save(existingQuestion);
        }
        return null;
    }
}