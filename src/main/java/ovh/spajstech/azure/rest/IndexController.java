package ovh.spajstech.azure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajstech.azure.model.IndexView;
import ovh.spajstech.azure.repository.EmployeeRepository;
import ovh.spajstech.azure.repository.PlacesRepository;

@RestController
public class IndexController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PlacesRepository placesRepository;

    @GetMapping("/")
    public IndexView index() {
        return new IndexView(employeeRepository.findAll(), placesRepository.findAll());
    }
}
