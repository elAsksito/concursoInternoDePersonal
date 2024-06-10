package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IExam;
import ads.cip.model.ExamModel;
import ads.cip.repository.ExamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExamImpl implements IExam {

    private final  ExamRepository examRepo;
    private static final String message = "Exam not found with id: ";

    public ExamImpl(ExamRepository examRepo) {
        this.examRepo = examRepo;
    }

    @Override
    public List<ExamModel> getAllExams() {
        return examRepo.findAll();
    }

    @Override
    public Optional<ExamModel> getExamById(String id) {
        if(!examRepo.existsById(id)){
            throw new NotFoundException(message + id);
        }
        return examRepo.findById(id);
    }

    @Override
    @Transactional
    public ExamModel saveExam(ExamModel exam) {
        if(examRepo.existsById(exam.getExamId())){
            throw new AlreadyExistsException("Exam already exists with id: " + exam.getExamId());
        }
        return examRepo.save(exam);
    }

    @Override
    @Transactional
    public void deleteExam(String id) {
        if(!examRepo.existsById(id)){
            throw new NotFoundException(message + id);
        }
        examRepo.deleteById(id);
    }

    @Override
    @Transactional
    public ExamModel updateExam(String id, ExamModel newExam) {
        Optional<ExamModel> optionalExam = examRepo.findById(id);
        if (optionalExam.isPresent()) {
            ExamModel existingExam = optionalExam.get();
            existingExam.setExamName(newExam.getExamName());
            existingExam.setExamDescription(newExam.getExamDescription());
            existingExam.setExamDate(newExam.getExamDate());
            existingExam.setPositionModel(newExam.getPositionModel());
            return examRepo.save(existingExam);
        }else {
            throw new NotFoundException(message + id);
        }
    }
}