public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Gosho", "Pedigree");
        Animal cat = new Cat("Pesho", "Caca");

        System.out.println(dog.explainSelf());
        System.out.println(cat.explainSelf());

    }
}
