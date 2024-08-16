package com.back_LimpPlast.service.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.back_LimpPlast.dao.EnderecoDao;
import com.back_LimpPlast.model.Endereco;

import dto.EnderecoDTO;
import mapper.GenericModelMapper;


@Component
public class ServiceEnderecoImpl implements IServiceEndereco {

	@Autowired
	private EnderecoDao dao;
	
	GenericModelMapper<Endereco, EnderecoDTO> mapperDTO = new GenericModelMapper<>(EnderecoDTO.class);
	
	GenericModelMapper<EnderecoDTO, Endereco> mapper = new GenericModelMapper<>(Endereco.class);

	public EnderecoDTO cadastrarNovo(EnderecoDTO endereco) {
		
		var Endereco = mapper.map(endereco);
		
		return mapperDTO.map(dao.save(Endereco));
}

	@Override
	public EnderecoDTO alterarEndereco(EnderecoDTO alterar) {
		
		var Enderecoalterar = mapper.map(alterar);
		
		
		return mapperDTO.map(dao.save(Enderecoalterar));

		
	}

	@Override
	public List<EnderecoDTO> listarEndereco() {

		return mapperDTO.mapList(dao.findAll());
	}

	@Override
	public void DeletarEndereco(Integer id) {
	
		dao.deleteById(id);

	}

	@Override
	public EnderecoDTO buscarPorId(Integer id) {
	   
		

       return  mapperDTO.map(dao.findById(id).orElse(null));
		
		}

}
