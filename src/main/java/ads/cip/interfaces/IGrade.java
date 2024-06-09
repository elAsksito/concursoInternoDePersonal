package ads.cip.interfaces;

import ads.cip.model.GradeModel;

import java.util.List;
import java.util.Optional;

public interface IGrade {
    List<GradeModel> getAllGrades();
    Optional<GradeModel> getGradeById(String id);
    GradeModel createGrade(GradeModel grade);
    void deleteGrade(String id);
    GradeModel updateGrade(String id, GradeModel newGrade);
}