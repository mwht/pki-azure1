package ovh.spajstech.azure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ovh.spajstech.azure.repository.EmployeeRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
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
        return new EmployeeModel(null, null, null);
    }

    @PostMapping(path = "/api/employees", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addEmployee(@RequestBody EmployeeModel employee, HttpServletResponse response)
    {
        repository.save(employee);
        response.setStatus(201);
    }
}
