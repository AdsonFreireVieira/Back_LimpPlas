package dto;

public class ItensPedidoDTO {

	private Integer id;
	private int quantidade;
	private Double valorItens;
	private PedidoDTO  pedido;
    private ProdutoDTO produto;
   
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorItens() {
		return valorItens;
	}
	public void setValorItens(Double valorItens) {
		this.valorItens = valorItens;
	}
    
    
    
}
