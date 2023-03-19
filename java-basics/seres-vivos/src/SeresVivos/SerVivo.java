package SeresVivos;

import java.util.ArrayList;
import java.util.Scanner;

public class SerVivo {
	
	Scanner scan = new Scanner(System.in);
	
	String filo;
	String classe;
	String ordem;
	String familia;
	String genero;
	String especie;
	ArrayList<Animalia> listaAnimalia = new ArrayList<Animalia>();
	ArrayList<Plantae> listaPlantae = new ArrayList<Plantae>();
	ArrayList<Monera> listaMonera = new ArrayList<Monera>();
	ArrayList<Fungi> listaFungi = new ArrayList<Fungi>();
	ArrayList<Protista> listaProtista = new ArrayList<Protista>();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	int comando, reino;


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
	}
	
	public int menuOptions() {
		System.out.println("===== MENU OPÇÕES =====");
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar Ser Vivo");
		System.out.println("2 - Listar Reino de Seres Vivos");
		System.out.print(ANSI_YELLOW + "Escolha o comando: " + ANSI_RESET);
		comando = scan.nextInt();
		return comando;
	}
	
	public void cadastroSerVivo() {
		System.out.println(ANSI_GREEN + "===== Cadastrando Ser Vivo =====" + ANSI_RESET);

		do {
			System.out.println("0 - Cancelar cadastro");
			System.out.println("1 - Animalia");
			System.out.println("2 - Plantae");
			System.out.println("3 - Monera");
			System.out.println("4 - Fungi");
			System.out.println("5 - Protista");
			System.out.print(ANSI_YELLOW + "Escolha o reino: " + ANSI_RESET);
			reino = scan.nextInt();
			
			if (reino != 0) {
				System.out.println("=====================");
			}
			
			switch(reino) {
				case 0:
					break;

				case 1:
					listaAnimalia.add(new Animalia());
					break;

				case 2:
					listaPlantae.add(new Plantae());
					break;

				case 3:
					listaMonera.add(new Monera());
					break;

				case 4:
					listaFungi.add(new Fungi());
					break;

				case 5:
					listaProtista.add(new Protista());
					break;

				default:
					System.out.println("Valor inválido!");
					break;
			}
			
			System.out.println("=====================");

		} while (	reino != 0 &&
					reino != 1 &&
					reino != 2 &&
					reino != 3 &&
					reino != 4 &&
					reino != 5);
	}
	
	public void listarSeresVivos() {
		System.out.println(ANSI_CYAN + "===== Listando Seres Vivos =====" + ANSI_RESET);

		do {
			System.out.println("0 - Cancelar listagem");
			System.out.println("1 - Animalia");
			System.out.println("2 - Plantae");
			System.out.println("3 - Monera");
			System.out.println("4 - Fungi");
			System.out.println("5 - Protista");
			System.out.print(ANSI_YELLOW + "Escolha o reino: " + ANSI_RESET);
			reino = scan.nextInt();
			
			System.out.println("===================");
			switch(reino) {
				case 0:
					break;

				case 1:
					if (listaAnimalia.size() > 0) {
						for (int i = 0; i < listaAnimalia.size(); i++)
							System.out.println("Animal no." + (i + 1) + ": " + listaAnimalia.get(i).toString());
					} else {
						System.out.println(ANSI_RED + "Nada cadastrado" + ANSI_RESET);
					}
					break;

				case 2:
					if (listaPlantae.size() > 0) {
						for (int i = 0; i < listaPlantae.size(); i++)
							System.out.println("Planta no." + (i + 1) + ": " + listaPlantae.get(i).toString());
					} else {
						System.out.println(ANSI_RED + "Nada cadastrado" + ANSI_RESET);
					}
					break;

				case 3:
					if (listaMonera.size() > 0) {
						for (int i = 0; i < listaMonera.size(); i++)
							System.out.println("Bactéria no." + (i + 1) + ": " + listaMonera.get(i).toString());
					} else {
						System.out.println(ANSI_RED + "Nada cadastrado" + ANSI_RESET);
					}
					break;	

				case 4:
					if (listaFungi.size() > 0) {
						for (int i = 0; i < listaFungi.size(); i++)
							System.out.println("Fungo no." + (i + 1) + ": " + listaFungi.get(i).toString());
					} else {
						System.out.println(ANSI_RED + "Nada cadastrado" + ANSI_RESET);
					}
					break;

				case 5:
					if (listaProtista.size() > 0) {
						for (int i = 0; i < listaProtista.size(); i++)
							System.out.println("Protozoário no." + (i + 1) + ": " + listaProtista.get(i).toString());
					} else {
						System.out.println(ANSI_RED + "Nada cadastrado" + ANSI_RESET);
					}
					break;									

				default:
					System.out.println("Valor inválido!");
					break;
			}
			
			System.out.println("===================");

		} while (	reino != 0 &&
					reino != 1 &&
					reino != 2 &&
					reino != 3 &&
					reino != 4 &&
					reino != 5);
	}
}