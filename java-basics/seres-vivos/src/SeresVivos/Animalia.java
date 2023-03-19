package SeresVivos;

public class Animalia extends SerVivo {
	
	public Animalia() {
		cadastrar();
	}
	
	@Override
	public String toString() {
		return "Filo: " + ANSI_YELLOW + this.filo + ANSI_RESET + ", Classe: " + ANSI_YELLOW + this.classe + ANSI_RESET + ", Ordem: " +
				ANSI_YELLOW + this.ordem + ANSI_RESET + ", Família: " + ANSI_YELLOW + this.genero + ANSI_RESET +
				", Espécie ou nome popular: " + ANSI_YELLOW + this.especie + ANSI_RESET;
	}
}