package com.example.TrabajoIntegrador;

import com.example.TrabajoIntegrador.model.Odontologo;
import com.example.TrabajoIntegrador.model.Paciente;
import com.example.TrabajoIntegrador.model.Turno;
import com.example.TrabajoIntegrador.repository.OdontologoRepository;
import com.example.TrabajoIntegrador.repository.PacienteRepository;
import com.example.TrabajoIntegrador.repository.TurnoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class TrabajoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoIntegradorApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
}