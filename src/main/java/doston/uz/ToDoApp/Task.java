// ! You could give better name for this file , like Task.entity.java
package doston.uz.ToDoApp;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int taskId;

        @Column(name = "user_id")
        private int userId;

        private String name;

        @Column(name = "start_date")
        private LocalDate startDate;

        @Column(name = "end_date")
        private LocalDate endDate;

        private int priority;
        private String status;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        // Constructors
        public Task() {
                this.createdAt = LocalDateTime.now();
        }

        public Task(int userId, String name, LocalDate startDate, LocalDate endDate, int priority, String status) {
                this.userId = userId;
                this.name = name;
                this.startDate = startDate;
                this.endDate = endDate;
                this.priority = priority;
                this.status = status;

        }

        // Getters and Setters
        public int getTaskId() {
                return taskId;
        }

        public void setTaskId(int taskId) {
                this.taskId = taskId;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public LocalDate getStartDate() {
                return startDate;
        }

        public void setStartDate(LocalDate startDate) {
                this.startDate = startDate;
        }

        public LocalDate getEndDate() {
                return endDate;
        }

        public void setEndDate(LocalDate endDate) {
                this.endDate = endDate;
        }

        public int getPriority() {
                return priority;
        }

        public void setPriority(int priority) {
                this.priority = priority;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

//        public void setCreatedAt() {
//                this.createdAt = LocalDateTime.now();
//        }

        // toString method
        @Override
        public String toString() {
                return "Task{" +
                        "taskId=" + taskId +
                        ", userId=" + userId +
                        ", name='" + name + '\'' +
                        ", startDate=" + startDate +
                        ", endDate=" + endDate +
                        ", priority=" + priority +
                        ", status='" + status + '\'' +
                        ", createdAt=" + createdAt +
                        '}';
        }
}
