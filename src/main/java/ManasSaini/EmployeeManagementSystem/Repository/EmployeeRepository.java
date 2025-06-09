package ManasSaini.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ManasSaini.EmployeeManagementSystem.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
