package ovh.spajstech.azure.repository;

import org.springframework.stereotype.Component;
import ovh.spajstech.azure.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository()
    {
        this.employees = new ArrayList<>();
    }

    public List<Employee> findAll()
    {
        return employees;
    }

    public Optional<Employee> findById(Integer id)
    {
        return this.employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public boolean save(Employee employee)
    {
        if(employees.contains(employee))
        {
            employees.remove(employee);
            return employees.add(employee);
        }
        else
        {
            return employees.add(employee);
        }
    }
}
