package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IQuestion;
import ads.cip.model.QuestionModel;
import ads.cip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionImpl implements IQuestion {

    private final QuestionRepository questionRepository;
    private static final String message = "Question not found";

    @Autowired
    public QuestionImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionModel> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<QuestionModel> getQuestionById(String id) {
        if(!questionRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        return questionRepository.findById(id);
    }

    @Override
    @Transactional
    public QuestionModel saveQuestion(QuestionModel question) {
        if(questionRepository.existsById(question.getQuestionId())){
            throw new AlreadyExistsException("Exam already exists");
        }
        return questionRepository.save(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(String id) {
        if(!questionRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        questionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public QuestionModel updateQuestion(String id, QuestionModel newQuestion) {
        Optional<QuestionModel> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            QuestionModel existingQuestion = optionalQuestion.get();
            existingQuestion.setQuestionStatement(newQuestion.getQuestionStatement());
            existingQuestion.setExamModel(newQuestion.getExamModel());
            return questionRepository.save(existingQuestion);
        } else {
            throw new NotFoundException(message);
        }
    }
}