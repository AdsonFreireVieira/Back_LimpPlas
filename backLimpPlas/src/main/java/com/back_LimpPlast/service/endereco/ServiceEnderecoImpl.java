package com.back_LimpPlast.service.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.EnderecoDao;
import com.back_LimpPlast.model.endereco;

@Component
public class ServiceEnderecoImpl implements IServiceEndereco {

	@Autowired
	 private EnderecoDao dao;

	public endereco cadastrarNovo(endereco endereco) {
		
		return dao.save(endereco);
	}

	@Override
	public endereco alterarEndereco(endereco alterar) {
		
		return dao.save(alterar);
	}

	@Override
	public List<endereco> listarEndereco() {
		
		return dao.findAll();
	}

	@Override
	public endereco buscarPorNumero(int numero) {
		
		return dao.findByNumero(numero);
	}

	@Override
	public void DeletarEndereco(Integer id) {
	   dao.deleteById(id);
		
	}

}
