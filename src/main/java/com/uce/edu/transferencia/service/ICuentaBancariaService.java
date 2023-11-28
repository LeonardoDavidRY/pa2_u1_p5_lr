package com.uce.edu.transferencia.service;

import com.uce.edu.tranferencia.repository.modelo.CuentaBancaria;
import java.math.BigDecimal;
public interface ICuentaBancariaService {
	
	public CuentaBancaria  buscar(String numero);
	public void guardar(CuentaBancaria transferencia);
	public void actualizar(CuentaBancaria transferencia);
	public void eliminar(String numero);
	///Depositar e implementar un descuento del 10 porciento
    public void depositar(String numero, BigDecimal deposito);

}
