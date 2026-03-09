package up2date.up2dateSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.PlaceWorking;
import up2date.up2dateSecurity.repository.PlaceWorkingRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PlaceWorkingService {
    @Autowired
    private final PlaceWorkingRepository repository;

    public List<PlaceWorking> getAll() {
        return repository.findAll();
    }

    public PlaceWorking getById(Integer placeId) {
        return repository.findById(placeId).orElse(null);
    }

    public PlaceWorking save(PlaceWorking place) {
        return repository.save(place);
    }

    public void delete(Integer placeId) {
        repository.deleteById(placeId);
    }
}
