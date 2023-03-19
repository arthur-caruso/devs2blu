package SeresVivos;

public class Monera extends SerVivo {
	public Monera() {
		cadastrar();
	}

	@Override
	public String toString() {
		return ("Filo: " + ANSI_PURPLE + filo + ANSI_RESET +
				", Classe: " + ANSI_PURPLE + classe + ANSI_RESET +
				", Ordem: " + ANSI_PURPLE + ordem + ANSI_RESET +
				", Familia: " + ANSI_PURPLE + familia + ANSI_RESET +
				", Gênero: " + ANSI_PURPLE + genero + ANSI_RESET +
				", Espécie: " + ANSI_PURPLE + especie + ANSI_RESET);
	}
}