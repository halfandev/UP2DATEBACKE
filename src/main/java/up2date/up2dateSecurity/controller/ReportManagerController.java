package up2date.up2dateSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.ReportManager;
import up2date.up2dateSecurity.service.ReportManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/report-managers")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class ReportManagerController {

    private final ReportManagerService service;

    @GetMapping
    public List<ReportManager> getAll() {
        return service.getAll();
    }

    @GetMapping("/{managerId}")
    public ReportManager getById(@PathVariable Long managerId) {
        return service.getById(managerId);
    }

    @PostMapping
    public ReportManager create(@RequestBody ReportManager manager) {
        return service.save(manager);
    }

    @PutMapping("/{managerId}")
    public ReportManager update(@PathVariable Long managerId, @RequestBody ReportManager manager) {
        manager.setManagerId(managerId);
        return service.save(manager);
    }

    @DeleteMapping("/{managerId}")
    public void delete(@PathVariable Long managerId) {
        service.delete(managerId);
    }

}
