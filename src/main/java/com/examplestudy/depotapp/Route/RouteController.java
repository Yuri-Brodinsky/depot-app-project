package com.examplestudy.depotapp.Route;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/routes")
@PreAuthorize("hasAuthority('depot')")
public class RouteController {
    private final RoutService service;
    public RouteController(RoutService service){
        this.service = service;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('depot')")
    public List<Route> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public Route getById(@PathVariable Long id){
        return service.getById(id);
    }
    @PostMapping("/new")
    @PreAuthorize("hasAuthority('depot')")
    public void add(@RequestBody Route route){
        service.add(route);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void update(@RequestBody Route route){
        service.update(route);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('depot')")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
