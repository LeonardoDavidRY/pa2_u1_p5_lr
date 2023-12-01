package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	private ICuentaBancariaService iCuentaBancariaService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5LrApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//prueba
		// 1. Crear las cuentas
				CuentaBancaria ctaOrigen = new CuentaBancaria();
				ctaOrigen.setCedulaPropietario("1751674027");
				ctaOrigen.setNumero("1234");
				ctaOrigen.setSaldo(new BigDecimal(100));
				this.iCuentaBancariaService.guardar(ctaOrigen);

				CuentaBancaria ctaDestino = new CuentaBancaria();
				ctaDestino.setCedulaPropietario("1702353825");
				ctaDestino.setNumero("5678");
				ctaDestino.setSaldo(new BigDecimal(200));
				this.iCuentaBancariaService.guardar(ctaDestino);

				this.iTransferenciaService.realizar("1234","5678", new BigDecimal(20));

				System.out.println(ctaOrigen);
				System.out.println(ctaDestino);

				CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
				System.out.println(ctaOrigen1);
				CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
				System.out.println(ctaDestino1);

				this.iTransferenciaService.realizar("1234","5678", new BigDecimal(50));
				this.iTransferenciaService.realizar("5678","1234", new BigDecimal(10));

				//Contruir un reporte del estado de cuenta de todas las tranferencias}
				System.out.println("Reporte de Transferencias");
				int indice = 0;
				List<Transferencia> lista = this.iTransferenciaService.visulizarTodoList();
				for(Transferencia trans: lista) {
					indice++;
					System.out.println("Transferencia numero: "+indice+": "+trans.toString());
				}
				System.out.println("Gracias por utilizar nuestro servicio");

				System.out.println("Comprovacion del deposito con el 10%");
				//pendiente 

	}

}
