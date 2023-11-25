package com.uce.edu.transferencia.service;

import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public CuentaBancaria  buscar(String numero);
	public void guardar(CuentaBancaria transferencia);
	public void actualizar(CuentaBancaria transferencia);
	public void eliminar(String numero);
	

}
