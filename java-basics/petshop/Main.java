package petshop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer;
        String CPF;

        ArrayList<DogFood> dogFoods;
        DogFood dogFood;
        ArrayList<CatFood> catFoods;
        CatFood catFood;
        ArrayList<FishFood> fishFoods;
        FishFood fishFood;
        double amount;

        char option, option2, cardFlag;
        do {
            System.out.println("Options:");
            System.out.println("\t0 - Exit");
            System.out.println("\t1 - Register new customer");
            System.out.println("\t2 - Customer purchase");
            System.out.println("\t3 - Customer receipt");

            System.out.print("Option: ");
            option = kbd.nextLine().charAt(0);

            switch (option) {
                case '0':
                    System.out.println("Exiting program...");
                    break;

                case '1':
                    System.out.println("Registering new customer...");

                    System.out.print("\tCPF: ");
                    String cpf = kbd.nextLine();
                
                    customers.add(new Customer(cpf));
                    break;

                case '2':
                    System.out.println("Customer is purchasing...");

                    System.out.print("\tCPF: ");
                    CPF = kbd.nextLine();

                    customer = null;
                    for(int i = 0; i < customers.size(); i++)
                        if (customers.get(i).getCPF().equals(CPF))
                            customer = customers.get(i);

                    if (customer == null) {
                        System.out.println("Customer not found!");
                    } else {

                        
                        do {
                            System.out.println("Options:");
                            System.out.println("\t0 - Finish purchase");
                            System.out.println("\t1 - Purchase dog food");
                            System.out.println("\t2 - Purchase cat food");
                            System.out.println("\t3 - Purchase fish food");

                            System.out.print("Option: ");

                            option2 = kbd.nextLine().charAt(0);

                            switch (option2) {
                                case '0':
                                    System.out.println("Exiting program...");
                                    break;

                                case '1':
                                    System.out.print("\tAmount (Kg): ");
                                    amount = kbd.nextDouble();
                                    kbd.nextLine();
                                    customer.addDogFood(new DogFood("Dog food", amount));
                                    break;

                                case '2':
                                    System.out.print("\tAmount (Kg): ");
                                    amount = kbd.nextDouble();
                                    kbd.nextLine();
                                    customer.addCatFood(new CatFood("Cat food", amount));
                                    break;

                                case '3':
                                    System.out.print("\tAmount (Kg): ");
                                    amount = kbd.nextDouble();
                                    kbd.nextLine();
                                    customer.addFishFood(new FishFood("Fish food", amount));
                                    break;

                                default:
                                    System.out.println("Invalid option!");
                                    break;
                            }

                        } while (option2 != '0');
                    }
                    break;

                case '3':
                    System.out.println("Printing customer receipt...");

                    System.out.print("\tCPF: ");
                    CPF = kbd.nextLine();

                    customer = null;
                    for (int i = 0; i < customers.size(); i++)
                        if (customers.get(i).getCPF().equals(CPF))
                            customer = customers.get(i);

                    if (customer == null) {
                        System.out.println("Customer not found!");
                    } else {

                        System.out.print("\tUsing card? (y/n): ");
                        cardFlag = kbd.nextLine().charAt(0);

                        dogFoods = customer.getDogFoods();
                        for (int i = 0; i < dogFoods.size(); i++) {
                            dogFood = dogFoods.get(i);

                            System.out.printf("\t%s\n", dogFood.toString());

                            if (cardFlag == 'y') {
                                dogFood.setDiscount(0.1);
                                System.out.printf("\t\t$ %.2f Discount (10%%)\n", dogFood.discount);
                            }
                        }

                        catFoods = customer.getCatFoods();
                        for (int i = 0; i < catFoods.size(); i++) {
                            catFood = catFoods.get(i);

                            System.out.printf("\t%s\n", catFood.toString());

                            if (cardFlag == 'y') {
                                catFood.setDiscount(0.1);
                                System.out.printf("\t\t$ %.2f Discount (10%%)\n", catFood.discount);
                            }
                        }

                        fishFoods = customer.getFishFoods();
                        for (int i = 0; i < fishFoods.size(); i++) {
                            fishFood = fishFoods.get(i);
                            
                            System.out.printf("\t%s\n", fishFood.toString());

                            if (cardFlag == 'y') {
                                fishFood.setDiscount(0.1);
                                System.out.printf("\t\t$ %.2f Discount (10%%)\n", fishFood.discount);
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }

        } while (option != '0');

        kbd.close();
    }
}
