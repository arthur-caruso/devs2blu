package SeresVivos;

public class Protista extends SerVivo {
	
	String tipoProt, tipoAlimentacao, tipoReproducao;
	
	public Protista() {
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
		
		System.out.print("Esse Ser pertence as Algas ou Protozoários? ");
		tipoProt = scan.nextLine();
		
		System.out.print("Esse Ser é Autotrófico ou Heterotrófico? ");
		tipoAlimentacao = scan.nextLine();
		
		System.out.print("Esse Ser se reproduz Sexuada ou Assexuadamente? ");
		tipoReproducao = scan.nextLine();

	}
	
	
	@Override
	public String toString() {
		return "Reino: " + ANSI_CYAN + "Protista" + ANSI_RESET + " Filo: " + ANSI_CYAN + this.filo + ANSI_RESET + " Classe: " +  ANSI_CYAN + this.classe + ANSI_RESET + 
				" Ordem: " + ANSI_CYAN + this.ordem + ANSI_RESET + " Familia: " + ANSI_CYAN + this.familia + ANSI_RESET + " Gênero: " + ANSI_CYAN + this.genero + ANSI_RESET + 
				"\nEspécie: " + ANSI_CYAN + this.especie + ANSI_RESET + " Grande grupo: " + ANSI_CYAN + this.tipoProt + ANSI_RESET + " Alimentação: " + ANSI_CYAN + this.tipoAlimentacao + ANSI_RESET + 
				" Reprodução: " + ANSI_CYAN + this.tipoReproducao +ANSI_RESET;
	}
}