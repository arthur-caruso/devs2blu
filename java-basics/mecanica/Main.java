package mecanica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ArrayList<Carro> carros = new ArrayList<Carro>();
        ArrayList<Moto> motos = new ArrayList<Moto>();

        String cor;
        double quilometragem;

        int option, type;
        do {
            System.out.println("Opções:");
            System.out.println("\t0 - Sair");
            System.out.println("\t1 - Registrar novo veículo");
            System.out.println("\t2 - Listar veículos");

            System.out.print("Opção: ");
            option = kbd.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.print("Cor do veículo: ");
                    kbd.next();
                    cor = kbd.nextLine();
                    
                    System.out.print("Quilometragem do veículo: ");
                    quilometragem = kbd.nextDouble();

                    do {
                        System.out.println("Tipos de veículo:");
                        System.out.println("\t0 - Carro");
                        System.out.println("\t1 - Moto");

                        System.out.print("Opção: ");
                        type = kbd.nextInt();

                        switch (type) {
                            case 0:
                                carros.add(new Carro(cor, quilometragem));
                                break;

                            case 1:
                                motos.add(new Moto(cor, quilometragem));
                                break;

                            default:
                                System.out.println("Tipo inválido!");
                                break;
                        }

                    } while (type != 0 && type != 1);

                    break;

                case 2:
                    if (carros.size() != 0) {
                        System.out.println("Carros no conserto:");
                        for (int i = 0; i < carros.size(); i++)
                            System.out.println("\t" + carros.get(i).toString());
                    }

                    if (motos.size() != 0) {
                        System.out.println("Motos no conserto:");
                        for (int i = 0; i < motos.size(); i++)
                            System.out.println("\t" + motos.get(i).toString());
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (option != 0);

        kbd.close();
    }
}
