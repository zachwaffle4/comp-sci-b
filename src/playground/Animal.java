package playground;

public abstract class Animal {
    String name;

    public abstract void speak();
}

class Dog extends Animal {
    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println("woof");
    }
}