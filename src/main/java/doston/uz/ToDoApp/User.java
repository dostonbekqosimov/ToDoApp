package doston.uz.ToDoApp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_sequence", sequenceName = "users_seq", allocationSize = 1)
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
        private int userId;
        private String firstName;
        private String lastName;
        private String email;
        @Column(name="createdAt")
        private LocalDateTime createdAt;

        public User() {
                // Default constructor
                this.createdAt = LocalDateTime.now();
        }

        public User(String firstName, String lastName, String email) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                onCreate();
        }


        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }


        protected void onCreate() {
                createdAt = LocalDateTime.now();
                System.out.println("Meni chaqirishdi brat!");
        }

        @Override
        public String toString() {
                return "User{" +
                        "userId=" + userId +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", email='" + email + '\'' +
                        ", createdAt=" + createdAt +
                        '}';
        }
}
