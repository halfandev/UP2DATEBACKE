package up2date.up2dateSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.PlaceWorking;
import up2date.up2dateSecurity.service.PlaceWorkingService;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class PlaceWorkingController {

    private final PlaceWorkingService service;

    @GetMapping
    public List<PlaceWorking> getAll() {
        return service.getAll();
    }

    @GetMapping("/{workingId}")
    public PlaceWorking getById(@PathVariable Integer placeId) {
        return service.getById(placeId);
    }

    @PostMapping
    public PlaceWorking create(@RequestBody PlaceWorking place) {
        return service.save(place);
    }

    @PutMapping("/{placeId}")
    public PlaceWorking update(@PathVariable Integer placeId, @RequestBody PlaceWorking place) {
        place.setPlaceId(placeId);
        return service.save(place);
    }

    @DeleteMapping("/{placeId}")
    public void delete(@PathVariable Integer placeId) {
        service.delete(placeId);
    }

}
