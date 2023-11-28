package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.tranferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuentaBancaria);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);

	}

	@Override
	public void depositar(String numero, BigDecimal deposito) {
		// TODO Auto-generated method stub
		BigDecimal descuento = new BigDecimal(0.1);
		System.out.println("" + descuento);
		BigDecimal restar = deposito.multiply(descuento);
		BigDecimal depositoFinal = deposito.subtract(restar);
		CuentaBancaria ctaTmp = this.buscar(numero);
		BigDecimal saldoActual = ctaTmp.getSaldo();
		BigDecimal nuevoSaldo = saldoActual.add(depositoFinal);
		ctaTmp.setSaldo(nuevoSaldo);
		actualizar(ctaTmp);

	}

}
