package agenda;

public class Endereco {

	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private int cep;

	public Endereco(String estado, String cidade, String bairro, String rua, int numero, int cep) {
		super();
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}

	public String toString() {
		return	estado + ", " +
				cidade + ", " +
				bairro + ", " +
				rua + ", " +
				numero + ", " +
				cep;
	}
}
