package ads.cip.interfaces;

import ads.cip.model.ExamModel;

import java.util.List;
import java.util.Optional;

public interface IExam {
    List<ExamModel> getAllExams();
    Optional<ExamModel> getExamById(String id);
    ExamModel saveExam(ExamModel exam);
    void deleteExam(String id);
    ExamModel updateExam(String id, ExamModel newExam);
}