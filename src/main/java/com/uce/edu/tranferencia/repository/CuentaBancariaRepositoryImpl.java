package com.uce.edu.tranferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;
@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static List<CuentaBancaria> base= new ArrayList<CuentaBancaria>();

	@Override
	public CuentaBancaria seleccionar(String nuemro) {
	
		for(CuentaBancaria cuenta : base) {
			if (cuenta.getNumero().equals(nuemro)) {
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		base.add(cuentaBancaria);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);
		
	}

	@Override
	public void eliminar(String numero) {
		CuentaBancaria cuentaBancaria = this.seleccionar(numero);
		base.remove(cuentaBancaria);
	
	}

}
