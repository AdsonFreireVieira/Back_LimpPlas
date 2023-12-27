package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.ClientesDao;
import com.back_LimpPlast.model.Clientes;

@Component
public class ServiceClienteImpl implements IClienteService {

	 @Autowired
	private ClientesDao dao;
	 
	@Override
	public Clientes cadastrarNovo(Clientes cliente) {
		
		return dao.save(cliente);
	}

	@Override
	public Clientes alterarDados(Clientes alterar) {
		 
		return dao.save(alterar);
	}

	@Override
	public List<Clientes> ListarTodos() {
		
		return dao.findAll();
	}

	@Override
	public Clientes buscarporNome(String nome) {
		
		return dao.findByname(nome);
	}

	@Override
	public void deletarPorId(int id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public Clientes buscarPorId(int id) {
	
		return dao.findById(id).orElse(null);
	}

}
