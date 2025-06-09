package ManasSaini.EmployeeManagementSystem.Service.Interfaces;

import ManasSaini.EmployeeManagementSystem.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    //User profile methods
    User getUserByUsername(String username);
    User updateUserProfile(String username, User updatedUser);
}
