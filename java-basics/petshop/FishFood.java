package petshop;

public class FishFood extends PetFood {
    public FishFood() {
        super();
    }

    public FishFood(String name, double amount) {
        super(name, amount);
    }

    @Override
    public double getPrice() {
        return amount * 12.0;
    }
}