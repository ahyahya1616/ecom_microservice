package ma.fstt.userservice;

import ma.fstt.userservice.entities.User;
import ma.fstt.userservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}




	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			userRepository.save(User.builder()
					.username("admin")
					.password("admin123")
					.email("admin@gmail.com")
					.build());

			userRepository.save(User.builder()
					.username("user1")
					.password("user123")
					.email("user1@gmail.com")
					.build());

			userRepository.save(User.builder()
					.username("user2")
					.password("pass456")
					.email("user2@gmail.com")
					.build());

		};
	}

}
