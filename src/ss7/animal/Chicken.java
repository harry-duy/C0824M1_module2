package ss7.animal;

import ss7.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "chicken: cluck-cluck";
    }
    @Override
    public String howToEat() {
        return "coudl be fried";
    }
}
