package agenda;

import java.util.ArrayList;

public class Contato {

	private String nome;
	private String telefone;
	private ArrayList<Endereco> enderecos = new ArrayList<>();

	public String getNome() {
		return nome;
	}
	
	public Contato(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco(int i) {
		return enderecos.get(i);
	}

	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	
	}

	public String toString() {
		String out = nome + ", " + telefone + ", {";

		for (int i = 0; i < enderecos.size(); i++) {
			out += "Endereço " + i + ": " + enderecos.get(i).toString();
		}

		out += "}";

		return out;
	}

}
