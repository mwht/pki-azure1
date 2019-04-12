package ovh.spajstech.azure.model;

import java.util.List;

public class IndexView {
    private List<Employee> employees;
    private List<Place> places;

    public IndexView() {
        this(null, null);
    }

    public IndexView(List<Employee> employees, List<Place> places) {
        this.employees = employees;
        this.places = places;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
