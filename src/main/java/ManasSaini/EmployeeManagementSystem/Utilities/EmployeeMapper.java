package ManasSaini.EmployeeManagementSystem.Utilities;

import ManasSaini.EmployeeManagementSystem.DTO.EmployeeDTO;
import ManasSaini.EmployeeManagementSystem.Entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}
