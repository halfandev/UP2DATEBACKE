package up2date.up2dateSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import up2date.up2dateSecurity.model.ReportManager;
import up2date.up2dateSecurity.repository.ReportManagerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportManagerService {

    private final ReportManagerRepository repository;

    public List<ReportManager> getAll() {
        return repository.findAll();
    }

    public ReportManager getById(Long managerId) {
        return repository.findById(managerId).orElse(null);
    }

    public ReportManager save(ReportManager manager) {
        return repository.save(manager);
    }

    public void delete(Long managerId) {
        repository.deleteById(managerId);
    }
}
