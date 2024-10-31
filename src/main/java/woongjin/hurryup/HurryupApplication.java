package woongjin.hurryup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class HurryupApplication {

	public static void main(String[] args) {
		SpringApplication.run(HurryupApplication.class, args);
	}

}
