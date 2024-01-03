package com.back_LimpPlast.service.endereco;

import java.util.List;

import com.back_LimpPlast.model.endereco;

public interface IServiceEndereco {
	
	public endereco cadastrarNovo(endereco endereco);
	
	public endereco alterarEndereco(endereco alterar);
	
	public List<endereco> listarEndereco();
	
	public  endereco buscarPorNumero(int numero);
	
	public void DeletarEndereco(Integer id);
	
	

}
