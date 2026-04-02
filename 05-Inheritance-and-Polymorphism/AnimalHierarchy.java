
public class Question4 {

    static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void makeSound() {
            System.out.println("This animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }

        public void makeSound() {
            System.out.println("Dog says: Woof!");
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        public void makeSound() {
            System.out.println("Cat says: Meow!");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        dog.makeSound();
        cat.makeSound();
    }
}
