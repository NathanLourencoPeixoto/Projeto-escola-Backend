package br.com.escolasystem.professores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProfessoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessoresApplication.class, args);
	}

}
