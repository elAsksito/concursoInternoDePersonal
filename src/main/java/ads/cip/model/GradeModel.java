package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Grades")
@Data
public class GradeModel {

    @Id
    @Column(name = "grade_id", length = 7)
    private String gradeId;

    @Column(name = "grade_score", precision = 5, scale = 2)
    private float gradeScore;

    @Column(name = "grade_date", length = 7)
    private Date gradeDate;

    @ManyToOne
    @JoinColumn(name = "user_id_fk", referencedColumnName = "user_id")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "exam_id_fk", referencedColumnName = "exam_id")
    private ExamModel examModel;
}