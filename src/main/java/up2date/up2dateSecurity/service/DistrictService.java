package up2date.up2dateSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.District;
import up2date.up2dateSecurity.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    public DistrictRepository repository;

    public District add(District district) {
        return repository.save(district);
    }

    public List<District> all() {
        return repository.findAll();
    }

    public Optional<District> findOne(Integer districtId) {
        return repository.findById(districtId);
    }

    public void deleteMe(Integer districtId) {
        repository.deleteById(districtId);
    }

}
