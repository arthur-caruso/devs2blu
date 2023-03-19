package SeresVivos;


public class Main extends SerVivo{

	public static void main(String[] args) {


		SerVivo sV = new SerVivo();
		int opcao;

		do {
			opcao = sV.menuOptions();
			switch (opcao) {
			
			case 0:
				break;
				
			case 1:
				sV.cadastroSerVivo();
				break;
				
			case 2:
				sV.listarSeresVivos();
				break;
				
			default:
				System.out.println("Valor inválido!");
				break;
			}
			
		} while (opcao != 0);
	}
}
