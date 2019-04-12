package ovh.spajstech.azure.repository;

import org.springframework.stereotype.Component;
import ovh.spajstech.azure.rest.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepository {
    private List<EmployeeModel> employees;

    public EmployeeRepository()
    {
        this.employees = new ArrayList<>();
    }

    public List<EmployeeModel> findAll()
    {
        return employees;
    }

    public Optional<EmployeeModel> findById(Integer id)
    {
        return this.employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public boolean save(EmployeeModel employee)
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
