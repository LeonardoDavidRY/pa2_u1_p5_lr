package com.uce.edu.tranferencia.repository;

import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	
	public CuentaBancaria seleccionar(String numero);
	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public void eliminar(String numero);

}
