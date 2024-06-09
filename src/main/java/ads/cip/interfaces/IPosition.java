package ads.cip.interfaces;

import ads.cip.model.PositionModel;

import java.util.List;
import java.util.Optional;

public interface IPosition {
    List<PositionModel> getAllPositions();
    Optional<PositionModel> getPositionById(String id);
    PositionModel savePosition(PositionModel position);
    void deletePositionById(String id);
    PositionModel updatePosition(String id, PositionModel newPosition);
}