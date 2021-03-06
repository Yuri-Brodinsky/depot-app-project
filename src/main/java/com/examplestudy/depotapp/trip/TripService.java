package com.examplestudy.depotapp.trip;

import com.examplestudy.depotapp.response.NotFoundException;
import com.examplestudy.depotapp.route.Route;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository repository;

    public TripService(TripRepository repository){this.repository = repository;}

    public List<Trip> findAll(){
        return repository.findAll();
    }
    public Trip findById(Long id) {
        Optional<Trip> optional = repository.findById(id);
        if(optional.isEmpty()) throw new NotFoundException("no such trip found");
        return optional.get();
    }
    public void add(Trip trip){
        repository.save(trip);
    }

    public void update(Trip trip){
        Optional<Trip> optional = repository.findById(trip.getId());
        if(optional.isPresent()){
            Trip item = new Trip();
            item.setId(trip.getId());
            item.setBus(trip.getBus());
            item.setDriver(trip.getDriver());
            item.setRoute(trip.getRoute());
            item.setDate(trip.getDate());
            item.setDepartureTime(trip.getDepartureTime());
            item.setTicketsSale(trip.getTicketsSale());
            item.setUsers(trip.getUsers());
            repository.save(item);
        }
        else throw new NotFoundException("no such trip found for update");
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Trip> findAllByRouteAndDate(Route route, LocalDate date){
        return repository.findAllByRouteAndDate(route,date);
    }

}
