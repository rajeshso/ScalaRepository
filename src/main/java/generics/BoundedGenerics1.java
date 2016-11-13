package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by e797240 on 04/11/2016.
 */
class Animal1 implements Comparable<Animal1> {
    private int age;
    Animal1(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    public int compareTo(Animal1 animal1) {
        return this.getAge() > animal1.getAge() ? 0 :1;
    }
}
class Lion1 extends Animal1  {
    Lion1(int age) {
        super(age);
    }
}
class Zebra1 extends Animal1 {
    Zebra1(int age) {
        super(age);
    }
}


class BoundedGenerics1 {
    public static void main(String... args) {
        //Create a collection of Lions and sort
        List<Lion1> lionEnclosure = new ArrayList<>();
        lionEnclosure.add(new Lion1(10));
        lionEnclosure.add(new Lion1(11));
        sort(lionEnclosure);
        //Create a collection of Zebras and Lions and sort
        List<Animal1> animalEnclosure = new ArrayList<>();
        animalEnclosure.add(new Lion1(12));
        animalEnclosure.add(new Zebra1(14));
        sort(animalEnclosure);
    }
    //public static <A extends Comparable<A>> void sort(List<A> list) {
    public static <A extends Comparable<? super A>> void sort(List<A> list) {
        Collections.sort(list);
    }
}