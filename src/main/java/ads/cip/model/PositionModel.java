package ads.cip.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "Positions")
@Data
public class PositionModel {

    @Id
    @Column(name="position_id", length = 7)
    private String positionId;

    @Column(name="position_name", length = 250)
    private String positionName;

    @Column(name="position_description", length = 500)
    private String positionDescription;
}