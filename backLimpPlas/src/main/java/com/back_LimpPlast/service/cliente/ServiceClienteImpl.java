package com.back_LimpPlast.service.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back_LimpPlast.dao.ClientesDao;
import com.back_LimpPlast.model.clientes;

@Service
public class ServiceClienteImpl implements IClienteService {

	 @Autowired
	private ClientesDao dao; 
	 
	@Override
	public clientes cadastrarNovo(clientes cliente) {
		
		return dao.save(cliente);
	}

	@Override
	public clientes alterarDados(clientes alterar) {
		 
		return dao.save(alterar);
	}

	@Override
	public List<clientes> ListarTodos() {
		
		return dao.findAll();
	}

	@Override
	public clientes buscarporNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
	public void deletarPorId(int id) {
		
		dao.deleteById(id);
		
	}

	@Override
	public clientes buscarPorId(int id) {
	
		return dao.findById(id).orElse(null);
	}

}
