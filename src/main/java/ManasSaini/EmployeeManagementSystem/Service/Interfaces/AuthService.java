package ManasSaini.EmployeeManagementSystem.Service.Interfaces;

import ManasSaini.EmployeeManagementSystem.DTO.AuthRequest;
import ManasSaini.EmployeeManagementSystem.DTO.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    ManasSaini.EmployeeManagementSystem.Entity.User register(AuthRequest request);
}
