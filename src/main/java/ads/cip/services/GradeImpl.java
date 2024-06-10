package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IGrade;
import ads.cip.model.GradeModel;
import ads.cip.repository.GradeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GradeImpl implements IGrade {

    private final GradeRepository gradeRepository;
    private static final String message = "Grade not found";

    public GradeImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<GradeModel> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional<GradeModel> getGradeById(String id) {
        if(!gradeRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        return gradeRepository.findById(id);
    }

    @Override
    @Transactional
    public GradeModel createGrade(GradeModel grade) {
         if(gradeRepository.existsById(grade.getGradeId())){
             throw new AlreadyExistsException("Grade already exists");
         }
        return gradeRepository.save(grade);
    }

    @Override
    @Transactional
    public void deleteGrade(String id) {
        if(!gradeRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        gradeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public GradeModel updateGrade(String id, GradeModel newGrade) {
        Optional<GradeModel> optionalGrade = gradeRepository.findById(id);
        if (optionalGrade.isPresent()) {
            GradeModel existingGrade = optionalGrade.get();
            existingGrade.setGradeScore(newGrade.getGradeScore());
            existingGrade.setGradeDate(newGrade.getGradeDate());
            existingGrade.setUserModel(newGrade.getUserModel());
            existingGrade.setExamModel(newGrade.getExamModel());
            return gradeRepository.save(existingGrade);
        } else{
            throw new NotFoundException(message);
        }
    }
}