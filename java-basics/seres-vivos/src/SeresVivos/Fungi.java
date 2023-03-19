package SeresVivos;

public class Fungi extends SerVivo {
	String tipoDigestao, tipoReproducao, tipoRespiracao;

	public Fungi() {
		cadastrar();
	}

	@Override
	public void cadastrar() {
		System.out.print("Digite o filo: ");
		filo = scan.nextLine();

		System.out.print("Digite a classe: ");
		classe = scan.nextLine();

		System.out.print("Digite a ordem: ");
		ordem = scan.nextLine();

		System.out.print("Digite a família: ");
		familia = scan.nextLine();

		System.out.print("Digite o gênero: ");
		genero = scan.nextLine();

		System.out.print("Digite a espécie ou nome popular: ");
		especie = scan.nextLine();
		
		System.out.print("Qual é o tipo de digestão, extracelular ou por absorção? ");
		tipoDigestao = scan.nextLine();
		
		System.out.print("Qual é o tipo de Reprodução, Assexuada ou sexuada? ");
		tipoReproducao = scan.nextLine();
		
		System.out.print("Qual é o tipo de Respiração, Aeróbica ou Anaeróbica? ");
		tipoRespiracao = scan.nextLine();
	}

	@Override
	public String toString() {
		return	("Filo: " + ANSI_YELLOW + filo + ANSI_RESET +
				", Classe: " + ANSI_YELLOW + classe + ANSI_RESET + 
				", Ordem: " + ANSI_YELLOW + ordem + ANSI_RESET +
				", Familia: " + ANSI_YELLOW + familia + ANSI_RESET +
				", Gênero: " + ANSI_YELLOW + genero + ANSI_RESET +
				", Espécie: " + ANSI_YELLOW + especie + ANSI_RESET +
				"\nTipo de Digestao: " + ANSI_YELLOW + tipoDigestao + ANSI_RESET +
				", Tipo de Reproducao: " + ANSI_YELLOW + tipoReproducao + ANSI_RESET +
				", Tipo de Respiração: " + ANSI_YELLOW + tipoRespiracao + ANSI_RESET );
	}
}