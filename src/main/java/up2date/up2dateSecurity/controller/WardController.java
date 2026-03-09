package up2date.up2dateSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import up2date.up2dateSecurity.model.Ward;
import up2date.up2dateSecurity.service.WardService;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("api/v1/ward")
@CrossOrigin("*")
public class WardController {

    @Autowired
    public WardService service;

    @PostMapping
    public Ward add(@RequestBody Ward ward){
        return service.add(ward);
    }
    @GetMapping()
    public List<Ward> all(){
        return service.all();
    }
    @GetMapping("{wardId}")
    public Optional<Ward> findOne(@PathVariable Integer wardId){
        return service.findOne(wardId);
    }

    @DeleteMapping("{wardId}")
    public void deleteMe(@PathVariable Integer wardId){
        service.deleteMe(wardId);
    }
    @PutMapping("/{wardId}")
    public Ward update(@RequestBody Ward ward, @PathVariable Integer wardId){
        ward.setWardId(wardId);
        return service.add(ward);
    }

}
