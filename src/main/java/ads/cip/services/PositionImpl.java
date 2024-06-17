package ads.cip.services;

import ads.cip.exception.AlreadyExistsException;
import ads.cip.exception.NotFoundException;
import ads.cip.interfaces.IPosition;
import ads.cip.model.PositionModel;
import ads.cip.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PositionImpl implements IPosition {

    private final PositionRepository positionRepository;
    private static final String message = "Position not found";

    @Autowired
    public PositionImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionModel> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Optional<PositionModel> getPositionById(String id) {
        if(!positionRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        return positionRepository.findById(id);
    }

    @Override
    @Transactional
    public PositionModel savePosition(PositionModel position) {
        if(positionRepository.existsById(position.getPositionId())){
            throw new AlreadyExistsException("Position already exists");
        }
        return positionRepository.save(position);
    }

    @Override
    @Transactional
    public void deletePositionById(String id) {
        if(!positionRepository.existsById(id)) {
            throw new NotFoundException(message);
        }
        positionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PositionModel updatePosition(String id, PositionModel newPosition) {
        Optional<PositionModel> optionalPosition = positionRepository.findById(id);
        if (optionalPosition.isPresent()) {
            PositionModel existingPosition = optionalPosition.get();
            existingPosition.setPositionName(newPosition.getPositionName());
            existingPosition.setPositionDescription(newPosition.getPositionDescription());
            return positionRepository.save(existingPosition);
        } else {
            throw new NotFoundException(message);
        }
    }
}