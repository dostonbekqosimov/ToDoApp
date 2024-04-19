package doston.uz.ToDoApp.service;

import doston.uz.ToDoApp.Task;
import doston.uz.ToDoApp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public String addNewTask(Task task) {
        taskRepository.save(task);
        return "New task added!";
    }

    public Task getTask(Integer taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            System.out.println("Task with this id not found");
        }
        return task.get();

    }

    public String updateTask(Integer taskId, Task task) {

        Optional<Task> task1 = taskRepository.findById(taskId);
        if (task1.isEmpty()) {
            System.out.println("Task with this id not found");
        }

        Task existingTask = task1.get();

        existingTask.setUserId(task.getUserId());
        existingTask.setName(task.getName());
        existingTask.setStartDate(task.getStartDate());
        existingTask.setEndDate(task.getEndDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());

        taskRepository.save(existingTask);
        return "Task with updated! ";
    }

    public String deleteTask(Integer taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException("student with id-" + taskId + " doesn't exist");
        }
        taskRepository.deleteById(taskId);
        return "Task deleted!";
    }
}
