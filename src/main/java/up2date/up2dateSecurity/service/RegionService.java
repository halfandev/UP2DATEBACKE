package up2date.up2dateSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.Region;
import up2date.up2dateSecurity.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    public RegionRepository repository;

    public Region add(Region region) {
        return repository.save(region);
    }
    public List<Region> all() {
        return repository.findAll();
    }
    public Optional<Region> getOne(Integer regionId) {
        return repository.findById(regionId);
    }

    public void deleteMe(Integer regionId) {
        repository.deleteById(regionId);
    }
}
