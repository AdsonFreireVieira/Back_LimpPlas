package dto;

import java.time.LocalDate;

import java.util.List;

import com.back_LimpPlast.model.User;
import com.back_LimpPlast.model.itens_Pedido;
public class PedidoDTO {

	private Integer id;
	private LocalDate data;
	private double desconto;
	private int quantidade;
	private double valorTotal;
	private String status;
	
	private  UserDTO user;
	private List<ItensPedidoDTO> itens;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public List<ItensPedidoDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItensPedidoDTO> itens) {
		this.itens = itens;
	}
	
	
	
}
