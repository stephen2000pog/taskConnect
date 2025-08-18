package com.stephen.bootstrap;

import com.stephen.repository.UserRepository;
import com.stephen.service.AuthService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DataSeeder implements ApplicationRunner {

	private final UserRepository userRepository;
	private final AuthService authService;

	public DataSeeder(UserRepository userRepository, AuthService authService) {
		this.userRepository = userRepository;
		this.authService = authService;
	}

	@Override
	public void run(ApplicationArguments args) {
		// Seed a default CLIENT user if not present
		final String seedEmail = "client@example.com";
		final String seedPassword = "Secret123!";
		if (userRepository.findByEmail(seedEmail).isEmpty()) {
			authService.register(seedEmail, seedPassword, "CLIENT");
		}
	}
}

