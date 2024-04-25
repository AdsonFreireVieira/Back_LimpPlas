package com.back_LimpPlast.service.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.EnderecoDao;
import com.back_LimpPlast.model.Endereco;

@Component
public class ServiceEnderecoImpl implements IServiceEndereco {

	@Autowired
	 private EnderecoDao dao;

	public Endereco cadastrarNovo(Endereco endereco) {
		
		return dao.save(endereco);
	}

	@Override
	public Endereco alterarEndereco(Endereco alterar) {
		
		return dao.save(alterar);
	}

	@Override
	public List<Endereco> listarEndereco() {
		
		return dao.findAll();
	}


	@Override
	public void DeletarEndereco(Integer id) {
	   dao.deleteById(id);
		
	}

	@Override
	public Endereco buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
