package doston.uz.ToDoApp.repository;

import doston.uz.ToDoApp.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
