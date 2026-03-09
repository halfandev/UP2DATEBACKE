package up2date.up2dateSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.Region;
import up2date.up2dateSecurity.service.RegionService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/region")
@CrossOrigin("*")
public class RegionController {

    @Autowired
    public RegionService service;

    @PostMapping
    public Region add(@RequestBody Region  region){
        return service.add(region);
    }
    @GetMapping
    public List<Region> all(){
        return service.all();
    }

    //    @GetMapping("{jobId}")
    @GetMapping("{regionId}")
    public Optional<Region> getOne(@PathVariable Integer regionId){
        return service.getOne(regionId);
    }

    @PutMapping("{regionId}")
    public Region update(@RequestBody Region  region,@PathVariable Integer regionId){
        region.setRegionId(regionId);
        return service.add(region);
    }

    @DeleteMapping("{regionId}")
    public void deleteMe(@PathVariable Integer regionId){
        service.deleteMe(regionId);

    }
}
