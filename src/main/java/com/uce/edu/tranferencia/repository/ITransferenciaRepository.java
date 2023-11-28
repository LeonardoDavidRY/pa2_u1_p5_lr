package com.uce.edu.tranferencia.repository;

import com.uce.edu.tranferencia.repository.modelo.Transferencia;
import java.util.List;
public interface ITransferenciaRepository {
	
	public Transferencia selecionar(String numero);
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void eliminar(String numero);
	public List<Transferencia> selecionarTodo();

}
