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

	@Bean
	CommandLineRunner start(OdontologoRepository or){
		return args -> {
			Odontologo o1  = new Odontologo("Perez", "Jose", "m01");
			Odontologo o2  = new Odontologo("Calix", "Maria", "m02");
			or.save(o1);
			or.save(o2);
		};
	}

	@Bean
	CommandLineRunner start2(PacienteRepository or){
		return args -> {
			Paciente o1  = new Paciente("Benitez", "Esteban", "calle1", 123435, LocalDate.now());
			or.save(o1);
		};
	}

	@Bean
	CommandLineRunner start3(TurnoRepository or){
		return args -> {
			Paciente p1 = new Paciente("Sic", "Ana", "calle2", 123435,LocalDate.now());
			Odontologo d1 = new Odontologo("Luks", "Tefi", "m03");
			Turno o1  = new Turno(d1,p1, LocalDateTime.of(2022,8,10,15,46));
			or.save(o1);
		};
	}
}
