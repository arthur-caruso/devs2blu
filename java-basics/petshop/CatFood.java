package petshop;

public class CatFood extends PetFood {
    public CatFood() {
        super();
    }

    public CatFood(String name, double amount) {
        super(name, amount);
    }

    @Override
    public double getPrice() {
        return amount * 16.0;
    }
}