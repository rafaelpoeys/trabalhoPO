package trabalhoPO;

public class Multa {
	
	private String placa;
	private String nome;
	private String endereco;
	private String data;
	private String hora;
	
	public Multa() {
		
	}
	
	public Multa(String placa, String nome, String endereco, String data, String hora) {
		super();
		this.placa = placa;
		this.nome = nome;
		this.endereco = endereco;
		this.data = data;
		this.hora = hora;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	

}