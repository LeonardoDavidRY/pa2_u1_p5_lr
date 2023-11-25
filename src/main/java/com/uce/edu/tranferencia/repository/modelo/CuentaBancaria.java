package com.uce.edu.tranferencia.repository.modelo;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CuentaBancaria {
	private String numero;
	private String cedulaPropietario;
	private BigDecimal saldo;
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}

}
