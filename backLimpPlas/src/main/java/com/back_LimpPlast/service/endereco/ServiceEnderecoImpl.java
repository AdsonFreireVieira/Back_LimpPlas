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

	@Override
	public Endereco cadastrarNovo(Endereco endereco) {
		 
		return dao.save(endereco);
	}

	@Override
	public Endereco alterarEndereco(Endereco alterar) {
		// TODO Auto-generated method stub
		return dao.save(alterar);
	}

	@Override
	public List<Endereco> listarEndereco() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Endereco buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public void DeletarEndereco(Integer id) {
		dao.deleteById(id);
		
	}
	
}
