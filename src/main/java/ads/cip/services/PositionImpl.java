package ads.cip.services;

import ads.cip.interfaces.IPosition;
import ads.cip.model.PositionModel;
import ads.cip.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionImpl implements IPosition {

    private PositionRepository positionRepository;

    @Override
    public List<PositionModel> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<PositionModel> getPositionById(String id) {
        return positionRepository.findById(id);
    }

    @Override
    public PositionModel savePosition(PositionModel position) {
        return positionRepository.save(position);
    }

    @Override
    public void deletePositionById(String id) {
        positionRepository.deleteById(id);
    }

    @Override
    public PositionModel updatePosition(String id, PositionModel newPosition) {
        Optional<PositionModel> optionalPosition = positionRepository.findById(id);
        if (optionalPosition.isPresent()) {
            PositionModel existingPosition = optionalPosition.get();
            existingPosition.setPositionName(newPosition.getPositionName());
            existingPosition.setPositionDescription(newPosition.getPositionDescription());
            return positionRepository.save(existingPosition);
        }
        return null;
    }
}