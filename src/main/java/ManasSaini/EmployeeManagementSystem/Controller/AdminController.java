package ManasSaini.EmployeeManagementSystem.Controller;

import ManasSaini.EmployeeManagementSystem.DTO.EmployeeDTO;
import ManasSaini.EmployeeManagementSystem.DTO.UserDTO;
import ManasSaini.EmployeeManagementSystem.Entity.Employee;
import ManasSaini.EmployeeManagementSystem.Entity.User;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.EmployeeService;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.UserService;
import ManasSaini.EmployeeManagementSystem.Utilities.EmployeeMapper;
import ManasSaini.EmployeeManagementSystem.Utilities.UserMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@SecurityRequirement(name = "bearerAuth")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody Employee employee) {
        Employee saved = employeeService.createEmployee(employee);
        return ResponseEntity.ok(EmployeeMapper.toDTO(saved));
    }

//    @GetMapping("/employees")
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//
//        return ResponseEntity.ok(employeeService.getAllEmployees());
//    }
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> list = employeeService.getAllEmployees()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee saved = employeeService.getEmployeeById((id));
        return ResponseEntity.ok(EmployeeMapper.toDTO(saved));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee saved = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(EmployeeMapper.toDTO(saved));
    }

    @DeleteMapping("employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> list = userService.getAllUsers()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = UserMapper.toDTO(userService.getUserById(id));
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        UserDTO userDTO = UserMapper.toDTO(userService.updateUser(id, updatedUser));
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
