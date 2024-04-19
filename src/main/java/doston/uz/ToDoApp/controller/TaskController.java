package doston.uz.ToDoApp.controller;

import doston.uz.ToDoApp.Task;
import doston.uz.ToDoApp.User;
import doston.uz.ToDoApp.service.TaskService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
class TaskController{
    private TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    // getting all tasks
    @GetMapping("")
    public List<Task> getAllTasks(){
       return taskService.getAllTasks();
    }

    // adding new task
    @PostMapping("")
    public String addNewTask(@RequestBody Task task){
        return taskService.addNewTask(task);
    }

    // getting one task by id
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable("taskId")Integer taskId){
        return taskService.getTask(taskId);
    }

    // updating one task by id
    @PutMapping("/{taskId}")
    public String updateTask(
            @PathVariable("taskId")Integer taskId,
            @RequestBody Task task){
      return taskService.updateTask(taskId,task);

    }

    // deleting one task by id
    @DeleteMapping("/{taskId}")
    public String deleteStudent(@PathVariable("taskId") Integer taskId){
        return taskService.deleteTask(taskId);

    }


}
