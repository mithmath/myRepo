package rangeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rangeapp.repositories.RangeRepository;
import rangeapp.repositories.RangeRepositoryImpl;


@SpringBootApplication
public class RangeApplication {
	
	@Bean
	public RangeRepository rangeRepository() {
	    return new RangeRepositoryImpl();
	}

    public static void main(String[] args) {
        SpringApplication.run(RangeApplication.class, args);
    }
}
