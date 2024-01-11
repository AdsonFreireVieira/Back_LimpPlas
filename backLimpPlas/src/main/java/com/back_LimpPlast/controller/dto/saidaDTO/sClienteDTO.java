package com.back_LimpPlast.controller.dto.saidaDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.back_LimpPlast.controller.entradaDTO.eClienteDTO;
import com.back_LimpPlast.model.clientes;

public class sClienteDTO {

	private String nome;
	private int documento;
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public sClienteDTO sConvertDTO(clientes sDTO) {

		sClienteDTO sdto = new sClienteDTO();

		sdto.setDocumento(sDTO.getDocumento());
		sdto.setNome(sDTO.getNome());
		sdto.setEmail(sDTO.getEmail());

		return sdto;
	}
	
	public List<sClienteDTO> sConvertListDTO(List<clientes> cl){
		
		List<sClienteDTO> sDTO = new ArrayList<>();
		
	BeanUtils.copyProperties(sDTO,cl);
	
	return sDTO;
	}

}





