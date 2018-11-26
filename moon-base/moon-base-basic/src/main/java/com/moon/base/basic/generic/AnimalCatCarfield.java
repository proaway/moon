package com.moon.base.basic.generic;

import java.util.ArrayList;
import java.util.List;

public class AnimalCatCarfield {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>();
        List<Cat> cats = new ArrayList<Cat>();
        List<Carfield> carfields = new ArrayList<Carfield>();

        animals.add(new Animal());
        cats.add(new Cat());
        carfields.add(new Carfield());

        // List<? extends Cat> extendsCatFromAnimal=animals;
        List<? super Cat> superCatFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superCatFromCat = cats;

        List<? extends Cat> extendsCatFromCarfield = carfields;
        // List<? super Cat> superCatFromCarfield = carfields;

        extendsCatFromCat.add(null);
    }


}

class Animal {

}

class Cat extends Animal {

}

class Carfield extends Cat {

}