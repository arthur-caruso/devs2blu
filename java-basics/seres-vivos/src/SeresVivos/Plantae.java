package SeresVivos;

public class Plantae extends SerVivo {
	
	String tipoClassif, tipoDigestao, tipoReproducao, tipoRespiracao, tipoFrut;
	
	public Plantae() {
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
			
			System.out.println("Essa planta pertence as Classificação Briófitas, Pteridófitas, Gimnospermas ou Angiospermas? ");
			tipoClassif = scan.nextLine();
			
			System.out.print("Qual é o tipo de Reprodução, Assexuada ou sexuada? ");
			tipoReproducao = scan.nextLine();
			
			System.out.print("É uma planta Frutífera ou Não-frutífera? ");
			tipoFrut = scan.nextLine();
			
	}
		
		@Override
		public String toString() {
			return "Filo: " + ANSI_GREEN + this.filo + ANSI_RESET + ", Classe: " + ANSI_GREEN + this.classe + ANSI_RESET + ", Ordem: " +
					ANSI_GREEN + this.ordem + ANSI_RESET + ", Família: " + ANSI_GREEN + this.genero + ANSI_RESET +
				   ", Espécie ou nome popular: " + ANSI_GREEN + this.especie +ANSI_RESET
				   + "\nClassificação: " + ANSI_GREEN + this.tipoClassif + ANSI_RESET
				   + ", Reprodução: " + ANSI_GREEN + this.tipoReproducao + ANSI_RESET
				   +", Frutíferas: " + ANSI_GREEN+ this.tipoFrut +ANSI_RESET;
		
	}
}