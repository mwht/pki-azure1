package ovh.spajstech.azure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajstech.azure.model.Employee;
import ovh.spajstech.azure.repository.EmployeeRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/api/employees/")
    public List<Employee> getAllEmployees()
    {
        return repository.findAll();
    }

    @GetMapping("/api/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id)
    {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent())
        {
            return employee.get();
        }
        return new Employee(null, null, null);
    }

    @PostMapping(path = "/api/employees", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addEmployee(@RequestBody Employee employee, HttpServletResponse response)
    {
        repository.save(employee);
        response.setStatus(201);
    }
}
