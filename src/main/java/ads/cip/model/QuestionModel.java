package ads.cip.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Questions")
@Data
public class QuestionModel {

    @Id
    @Column(name = "question_id", length = 7)
    private String questionId;

    @Lob
    @Column(name = "question_statement")
    private String questionStatement;

    @ManyToOne
    @JoinColumn(name = "exam_id_fk", referencedColumnName = "exam_id")
    private ExamModel examModel;
}