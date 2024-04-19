package doston.uz.ToDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication {

	// database dagi malumotni o'qib bo'lmadi \\ epladik

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
		System.out.println("Men sho'ttaman");
	}


}
