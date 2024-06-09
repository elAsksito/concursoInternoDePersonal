package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Exams")
@Data
public class ExamModel {

    @Id
    @Column(name = "exam_id", length = 7)
    private String examId;

    @Column(name = "exam_name", length = 100, nullable = false)
    private String examName;

    @Column(name = "exam_description", length = 500)
    private String examDescription;

    @Column(name = "exam_date")
    private String examDate;

    @ManyToOne
    @JoinColumn(name = "position_id_fk", referencedColumnName = "position_id")
    private PositionModel positionModel;
}