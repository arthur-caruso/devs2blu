package petshop;

public class DogFood extends PetFood {
    public DogFood() {
        super();
    }

    public DogFood(String name, double amount) {
        super(name, amount);
    }

    @Override
    public double getPrice() {
        return amount * 24.0;
    }
}