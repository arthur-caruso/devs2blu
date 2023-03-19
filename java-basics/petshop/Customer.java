package petshop;

import java.util.ArrayList;

public class Customer {

    public String CPF;
    public ArrayList<DogFood> dogFoods = new ArrayList<DogFood>();
    public ArrayList<CatFood> catFoods = new ArrayList<CatFood>();
    public ArrayList<FishFood> fishFoods = new ArrayList<FishFood>();

    public Customer() {}

    public Customer(String CPF) {
        this.CPF = CPF;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public ArrayList<DogFood> getDogFoods() {
        return dogFoods;
    }

    public void setDogFoods(ArrayList<DogFood> dogFoods) {
        this.dogFoods = dogFoods;
    }

    public void addDogFood(DogFood dogFood) {
        dogFoods.add(dogFood);
    }

    public ArrayList<CatFood> getCatFoods() {
        return catFoods;
    }

    public void setCatFoods(ArrayList<CatFood> catFoods) {
        this.catFoods = catFoods;
    }

    public void addCatFood(CatFood catFood) {
        catFoods.add(catFood);
    }

    public ArrayList<FishFood> getFishFoods() {
        return fishFoods;
    }

    public void setFishFoods(ArrayList<FishFood> fishFoods) {
        this.fishFoods = fishFoods;
    }

    public void addFishFood(FishFood fishFood) {
        fishFoods.add(fishFood);
    }

}