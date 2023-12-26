package com.back_LimpPlast.service.endereco;

import java.util.List;

import com.back_LimpPlast.model.Endereco;

public interface IServiceEndereco {
	
	public Endereco cadastrarNovo(Endereco endereco);
	
	public Endereco alterarEndereco(Endereco alterar);
	
	public List<Endereco> listarEndereco();
	
	public  Endereco buscarPorNumero(int numero);
	
	public void DeletarEndereco(Integer id);
	
	

}
