package com.examplestudy.depotapp.trip;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@PreAuthorize("hasAuthority('depot')")
public class TripController {
    private final TripService service;
    public TripController(TripService service){
        this.service = service;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('depot')")
    public List<Trip> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public Trip getById(@PathVariable Long id){
        return service.findById(id);
    }
    @PostMapping("/new")
    @PreAuthorize("hasAuthority('depot')")
    public void add(@RequestBody Trip trip){
        service.add(trip);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void update(@RequestBody Trip trip){
        service.update(trip);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }



}
