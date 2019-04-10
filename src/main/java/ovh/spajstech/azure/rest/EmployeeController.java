package ovh.spajstech.azure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ovh.spajstech.azure.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/api/employees/")
    public List<EmployeeModel> getAllEmployees()
    {
        return repository.findAll();
    }

    @GetMapping("/api/employees/{id}")
    public EmployeeModel getEmployeeById(@PathVariable("id") Integer id)
    {
        Optional<EmployeeModel> employee = repository.findById(id);
        if(employee.isPresent())
        {
            return employee.get();
        }
        return new EmployeeModel();
    }
}
