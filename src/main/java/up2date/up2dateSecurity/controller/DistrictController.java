package up2date.up2dateSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.District;
import up2date.up2dateSecurity.service.DistrictService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/district")
@CrossOrigin("*")
public class DistrictController {

    @Autowired
    public DistrictService service;

    @PostMapping
    public District add(@RequestBody District district){
        return service.add(district);
    }
    @GetMapping()
    public List<District> all(){
        return service.all();
    }
    @GetMapping("{districtId}")
    public Optional<District> findOne(@PathVariable Integer districtId){
        return service.findOne(districtId);
    }
    @DeleteMapping("{districtId}")
    public void deleteMe(@PathVariable Integer districtId){
        service.deleteMe(districtId);
    }
    @PutMapping("{districtId}")
    public District update(@RequestBody District district, @PathVariable Integer districtId){
        district.setDistrictId(districtId);
        return service.add(district);
    }
}
