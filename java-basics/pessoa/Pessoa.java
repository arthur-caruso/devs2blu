package pessoa;

public class Pessoa {

	String nome;
	int anoNascimento;
	double peso;
    double altura;
    int idade;

	public Pessoa() {}

	public void cadastrarPessoa(String nome, int anoNascimento,
                                double peso, double altura) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.peso = peso;
		this.altura = altura;
        calcularIdade();
	}

	public void calcularIdade() {
		this.idade = 2022 - this.anoNascimento;
	}

}