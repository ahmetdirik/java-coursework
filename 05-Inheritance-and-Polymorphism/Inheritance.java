
// Üst (Parent) sınıf
class Animal {
    String name;

    public void makeSound() {
        System.out.println("Some sound...");
    }
}

// Alt (Child) sınıf, Animal sınıfından miras alıyor
class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

// Kullanım
public class Inheritance {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        System.out.println(myDog.name);  // Output: Buddy
        myDog.makeSound();               // Output: Bark
    }
}
