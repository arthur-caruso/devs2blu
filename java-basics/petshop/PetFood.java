package petshop;

public class PetFood {

    public String name;
    public double amount;
    public double discount;

    public PetFood() {}

    public PetFood(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return amount * 20.0;
    }

    public void setDiscount(double discount) {
        this.discount = getPrice() * discount;
    }

    public String toString() {
        return Double.toString(amount) + " Kg (" + name + ") $ " + getPrice();
    }

}