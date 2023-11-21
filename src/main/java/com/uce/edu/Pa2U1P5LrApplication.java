package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uce.edu.ioc.di.Estudiante;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication

public class Pa2U1P5LrApplication implements CommandLineRunner{
	
	@Autowired
	private Estudiante estudiante; 

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5LrApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.estudiante.setCedula("1723353825");
		this.estudiante.setNombre("Leonardo");
		this.estudiante.setApellido("Ramirez");
		this.estudiante.setSalario(new BigDecimal(1000));
		System.out.println(estudiante);
	}

}
