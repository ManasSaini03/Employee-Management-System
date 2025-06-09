package ManasSaini.EmployeeManagementSystem.Service.Impl;

import ManasSaini.EmployeeManagementSystem.Entity.Employee;
import ManasSaini.EmployeeManagementSystem.Repository.EmployeeRepository;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee updated) {
        Employee existing = getEmployeeById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setSalary(updated.getSalary());
        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
