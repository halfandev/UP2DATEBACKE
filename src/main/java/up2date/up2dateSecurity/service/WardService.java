package up2date.up2dateSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.Ward;
import up2date.up2dateSecurity.repository.WardRepository;

import java.util.List;
import java.util.Optional;
@Service
public class WardService {
    @Autowired
    public WardRepository repository;
    public Ward add(Ward ward) {
        return repository.save(ward);

    }

    public List<Ward> all() {
        return repository.findAll();
    }

    public Optional<Ward> findOne(Integer wardId) {
        return repository.findById(wardId);
    }

    public void deleteMe(Integer wardId) {
        repository.deleteById(wardId);
    }
}
