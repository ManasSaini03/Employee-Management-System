package ManasSaini.EmployeeManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ManasSaini.EmployeeManagementSystem.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
