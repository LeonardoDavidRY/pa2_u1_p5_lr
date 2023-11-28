package com.uce.edu.tranferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.tranferencia.repository.modelo.Transferencia;
@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	private static List<Transferencia> base= new ArrayList();
	@Override
	public Transferencia selecionar(String nuemro) {
		System.out.println("Seleccionamos: "+ nuemro);
		
		for(Transferencia mate : base) {
			if (mate.getNumero().equals(nuemro)) {
				return mate;
			}
		}
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		Transferencia materia = this.selecionar(numero);
		base.remove(materia);
		
	}

	@Override
	public List<Transferencia> selecionarTodo() {
		// TODO Auto-generated method stub
		return base;
	}



}
