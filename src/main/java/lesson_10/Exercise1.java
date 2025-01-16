package lesson_10;

import java.util.ArrayList;

public class Exercise1 {

    static class Fruit {}

    static class Apple extends Fruit {}

    static class Orange extends Fruit {}

    static class Box<T extends Fruit> {
        private final ArrayList<T> fruits = new ArrayList<>();

        public void addFruit(T fruit) {
            fruits.add(fruit);
        }

        public float getWeight() {
            if (fruits.isEmpty()) {
                return 0.0f;
            }

            if (fruits.getFirst() instanceof Apple) {
                return fruits.size() * 1.0f;
            }

            if (fruits.getFirst() instanceof Orange) {
                return fruits.size() * 1.5f;
            }

            return 0.0f;
        }

        public boolean compare(Box<?> Box2) {
            return this.getWeight() == Box2.getWeight();
        }

        public void transferTo(Box<T> Box2) {
            if (this == Box2) {
                return;
            }

            Box2.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки Яблок - " + appleBox.getWeight());
        System.out.println("Вес коробки Апельсинов - " + orangeBox.getWeight());
        System.out.println("Сравнение веса коробок - " + appleBox.compare(orangeBox));

        appleBox.transferTo(appleBox2);
        System.out.println("Вес 1 коробки " + appleBox.getWeight());
        System.out.println("Вес 2 коробки " + appleBox2.getWeight());

        orangeBox.transferTo(orangeBox2);
        System.out.println("Вес 1 коробки " + orangeBox.getWeight());
        System.out.println("Вес 2 коробки " + orangeBox2.getWeight());
    }
}
