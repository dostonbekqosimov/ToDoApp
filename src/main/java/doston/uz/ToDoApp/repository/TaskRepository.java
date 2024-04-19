package doston.uz.ToDoApp.repository;

import doston.uz.ToDoApp.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
