package ovh.spajstech.azure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajstech.azure.model.Place;
import ovh.spajstech.azure.repository.PlacesRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class PlacesController {

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping("/api/places")
    public List<Place> getAllPlaces() {
        return placesRepository.findAll();
    }

    @GetMapping("/api/places/{id}")
    public Place getPlaceById(@PathVariable("id") Integer id, HttpServletResponse response) {
        Optional<Place> placeHandle = placesRepository.findPlaceById(id);
        if(!placeHandle.isPresent()) {
            response.setStatus(404);
            return new Place();
        }
        return placeHandle.get();
    }

    @PostMapping(path = "/api/places", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addNewPlace(@RequestBody Place placeToAdd, HttpServletResponse response) {
        placesRepository.save(placeToAdd);
        response.setStatus(201);
    }

}
