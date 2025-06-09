package ManasSaini.EmployeeManagementSystem.Utilities;

import ManasSaini.EmployeeManagementSystem.DTO.UserDTO;
import ManasSaini.EmployeeManagementSystem.Entity.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(),
                user.getUsername(),
                user.getRole());

    }
}
