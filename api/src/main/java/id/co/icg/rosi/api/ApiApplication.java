package id.co.icg.rosi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class ApiApplication {
	public static final String PATH = "/api/v1";

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
