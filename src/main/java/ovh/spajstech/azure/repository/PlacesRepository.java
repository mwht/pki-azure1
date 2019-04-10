package ovh.spajstech.azure.repository;

import org.springframework.stereotype.Component;
import ovh.spajstech.azure.model.Place;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory places repository. This is just simple stub - real repository should be done with h2, this is quick
 * mockup
 *
 * @author Sebastian Madejski (@mwht)
 */
@Component
public class PlacesRepository {
    private List<Place> places;

    public PlacesRepository() {
        this.places = new ArrayList<>();
    }

    public List<Place> findAll() {
        return places;
    }

    public Optional<Place> findPlaceById(Integer id) {
        return places.stream().filter(place -> place.getId() == id).findFirst();
    }

    public boolean save(Place place) {
        if(places.contains(place)) {
            return false;
        } else {
            places.add(place);
        }
        return true;
    }
}
