package ads.cip.services;

import ads.cip.interfaces.IGrade;
import ads.cip.model.GradeModel;
import ads.cip.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeImpl implements IGrade {

    private GradeRepository gradeRepository;

    @Override
    public List<GradeModel> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<GradeModel> getGradeById(String id) {
        return gradeRepository.findById(id);
    }

    @Override
    public GradeModel createGrade(GradeModel grade) {
         return gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(String id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public GradeModel updateGrade(String id, GradeModel newGrade) {
        Optional<GradeModel> optionalGrade = gradeRepository.findById(id);
        if (optionalGrade.isPresent()) {
            GradeModel existingGrade = optionalGrade.get();
            existingGrade.setGradeScore(newGrade.getGradeScore());
            existingGrade.setGradeDate(newGrade.getGradeDate());
            existingGrade.setUserModel(newGrade.getUserModel());
            existingGrade.setExamModel(newGrade.getExamModel());
            return gradeRepository.save(existingGrade);
        }
        return null;
    }
}