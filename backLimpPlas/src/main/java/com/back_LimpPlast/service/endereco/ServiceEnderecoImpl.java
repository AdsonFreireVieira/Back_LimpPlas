package com.back_LimpPlast.service.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.EnderecoDao;
import com.back_LimpPlast.dto.EnderecoDTO;

@Component
public class ServiceEnderecoImpl implements IServiceEndereco {

	@Autowired
	private EnderecoDao dao;

	public EnderecoDTO cadastrarNovo(EnderecoDTO endereco) {

		var end = EnderecoDTO.convertToEndereco(endereco);

		return EnderecoDTO.converToEnderecoDTO(dao.save(end));
	}

	@Override
	public EnderecoDTO alterarEndereco(EnderecoDTO alterar) {

		var end = EnderecoDTO.convertToEndereco(alterar);

		return EnderecoDTO.converToEnderecoDTO(dao.save(end));
	}

	@Override
	public List<EnderecoDTO> listarEndereco() {

		return EnderecoDTO.convertListDTO(dao.findAll());
	}

	@Override
	public void DeletarEndereco(Integer id) {
		dao.deleteById(id);

	}

	@Override
	public EnderecoDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return EnderecoDTO.converToEnderecoDTO(dao.findById(id).orElse(null));
	}

}
