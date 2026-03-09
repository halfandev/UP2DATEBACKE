package up2date.up2dateSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.Zone;
import up2date.up2dateSecurity.repository.ZoneRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ZoneService {
    private final ZoneRepository repository;

    public List<Zone> getAll() {
        return repository.findAll();
    }

    public Zone getById(Integer zoneId) {
        return repository.findById(zoneId).orElse(null);
    }

    public Zone save(Zone zone) {
        return repository.save(zone);
    }

    public void delete(Integer zoneId) {
        repository.deleteById(zoneId);
    }
}
