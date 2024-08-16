package com.back_LimpPlast.service.endereco;

import java.util.List;

import com.back_LimpPlast.model.Endereco;

import dto.EnderecoDTO;

public interface IServiceEndereco {
	
	public EnderecoDTO cadastrarNovo(EnderecoDTO endereco);
	
	public EnderecoDTO alterarEndereco(EnderecoDTO alterar);
	
	public List<EnderecoDTO> listarEndereco();
	
	public EnderecoDTO buscarPorId(Integer id);
	
	
	public void DeletarEndereco(Integer id);
	
	

}
