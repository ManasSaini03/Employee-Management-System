package ManasSaini.EmployeeManagementSystem.Service.Impl;

import ManasSaini.EmployeeManagementSystem.DTO.AuthRequest;
import ManasSaini.EmployeeManagementSystem.DTO.AuthResponse;
import ManasSaini.EmployeeManagementSystem.Entity.User;
import ManasSaini.EmployeeManagementSystem.Repository.UserRepository;
import ManasSaini.EmployeeManagementSystem.Security.JwtUtil;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }

    @Override
    public User register(AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return userRepository.save(user);
    }
}
