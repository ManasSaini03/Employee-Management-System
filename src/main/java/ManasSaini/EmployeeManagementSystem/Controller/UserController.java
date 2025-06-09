package ManasSaini.EmployeeManagementSystem.Controller;

import ManasSaini.EmployeeManagementSystem.DTO.UserDTO;
import ManasSaini.EmployeeManagementSystem.Entity.User;
import ManasSaini.EmployeeManagementSystem.Service.Interfaces.UserService;
import ManasSaini.EmployeeManagementSystem.Utilities.UserMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(Authentication authentication) {
        String username = authentication.getName();
        UserDTO userDTO = UserMapper.toDTO(userService.getUserByUsername(username));
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDTO> updateProfile(@RequestBody User updatedUser, Authentication authentication) {
        String username = authentication.getName();
        UserDTO userDTO = UserMapper.toDTO(userService.updateUserProfile(username, updatedUser));
        return ResponseEntity.ok(userDTO);
    }
}
