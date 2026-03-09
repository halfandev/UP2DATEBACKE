package up2date.up2dateSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.Zone;
import up2date.up2dateSecurity.service.ZoneService;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class ZoneController {

    private final ZoneService service;

    @GetMapping
    public List<Zone> getAll() {
        return service.getAll();
    }

    @GetMapping("/{zoneId}")
    public Zone getById(@PathVariable Integer zoneId) {
        return service.getById(zoneId);
    }

    @PostMapping
    public Zone create(@RequestBody Zone zone) {
        return service.save(zone);
    }

    @PutMapping("/{zoneId}")
    public Zone update(@PathVariable Integer zoneId, @RequestBody Zone zone) {
        zone.setZoneId(zoneId);
        return service.save(zone);
    }

    @DeleteMapping("/{zoneId}")
    public void delete(@PathVariable Integer zoneId) {
        service.delete(zoneId);
    }

}
