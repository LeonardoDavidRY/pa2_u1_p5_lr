package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.tranferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.tranferencia.repository.ITransferenciaRepository;
import com.uce.edu.tranferencia.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.selecionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);

	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// 1.- Buscar cuenta origen
		this.bancariaRepository.seleccionar(numeroDestino);
	
		// 2.- consutar el saldo
		// 3.- Validar el saldo
		// 4.- Restar el monto
		// 5.- Actualizar cuenta origen
		
		// 6.- buscar cuenta destino
		// 7.- consultar saldo
		// 8.- Sumar el monto
		// 9.- Actualizar cuenta destino
		
		// 10.- Crear la transferencia
		
		
		
	}

}
