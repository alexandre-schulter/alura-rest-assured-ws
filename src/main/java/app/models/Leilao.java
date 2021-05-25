package app.models;


public class Leilao extends Entity {
	
	private String nome;
	private Double valorInicial;
	private Usuario usuario;
	private boolean usado;
	
	public Leilao() {}
	
	public Leilao(Long id, String nome, Double valorInicial, Usuario usuario,
			boolean usado) {
		this.id = id;
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.usuario = usuario;
		this.usado = usado;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public Double getValorInicial() {
		return valorInicial;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	
}
