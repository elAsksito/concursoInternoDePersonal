package ads.cip.services;

import ads.cip.interfaces.IExam;
import ads.cip.model.ExamModel;
import ads.cip.repository.ExamRepository;

import java.util.List;
import java.util.Optional;

public class ExamImpl implements IExam {

    private ExamRepository examRepo;
    @Override
    public List<ExamModel> getAllExams() {
        return examRepo.findAll();
    }

    @Override
    public Optional<ExamModel> getExamById(String id) {
        return examRepo.findById(id);
    }

    @Override
    public ExamModel saveExam(ExamModel exam) {
        return examRepo.save(exam);
    }

    @Override
    public void deleteExam(String id) {
        examRepo.deleteById(id);
    }

    @Override
    public ExamModel updateExam(String id, ExamModel newExam) {
        Optional<ExamModel> optionalExam = examRepo.findById(id);
        if (optionalExam.isPresent()) {
            ExamModel existingExam = optionalExam.get();
            existingExam.setExamName(newExam.getExamName());
            existingExam.setExamDescription(newExam.getExamDescription());
            existingExam.setExamDate(newExam.getExamDate());
            existingExam.setPositionModel(newExam.getPositionModel());
            return examRepo.save(existingExam);
        }
        return null;
    }
}