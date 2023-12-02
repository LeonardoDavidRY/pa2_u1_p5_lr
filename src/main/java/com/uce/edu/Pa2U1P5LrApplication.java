package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IIventarioService;
import com.uce.edu.inventario.service.IProductoService;
import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.tranferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

import java.util.List;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication

public class Pa2U1P5LrApplication implements CommandLineRunner {
	
    //DI por atributo
	@Autowired
	private ITransferenciaService iTransferenciaService;
	/*
	 * DI por constructor
	@Autowired
	public Pa2U1P5LrApplication(ITransferenciaService iTransServi) {
		this.iTransferenciaService = iTransServi;
	}
	*/
	//DI por metodo (set)
	/*
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}
	*/

	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IBodegaService iBodegaService;
	@Autowired
	private IIventarioService iInventarioService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5LrApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		Producto p1= new Producto();
		p1.setCodigoBarras("123455");
		p1.setNombre("HP 15 Laptop");
		p1.setStock(0);
		
		this.iProductoService.guardar(p1);
		
		Producto p2= new Producto();
		p2.setCodigoBarras("125889");
		p2.setNombre("HP teclado");
		p2.setStock(0);
		
		
		this.iProductoService.guardar(p2);
		
		Bodega b1= new Bodega();
		b1.setCapacidad(200);
		b1.setCodigo("5896");
		b1.setDireccion("Av america");
		b1.setNombre("Bodega 1");
		
		this.iBodegaService.guardar(b1);
		
		this.iInventarioService.registrar(b1.getCodigo(), p1.getCodigoBarras(), 50);
		this.iInventarioService.registrar(b1.getCodigo(), p2.getCodigoBarras(), 100);
		this.iInventarioService.registrar(b1.getCodigo(), p1.getCodigoBarras(), 20);
		
		System.out.println(this.iProductoService.buscar("123455"));
		System.out.println(this.iProductoService.buscar("125889"));
		
		

	}

}
