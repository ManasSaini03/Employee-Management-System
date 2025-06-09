package ManasSaini.EmployeeManagementSystem.Controller;

import ManasSaini.EmployeeManagementSystem.DTO.AuthRequest;
import ManasSaini.EmployeeManagementSystem.DTO.AuthResponse;
import ManasSaini.EmployeeManagementSystem.Entity.User;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "bearerAuth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
