package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.generics.coffee.Cappuccino;
import com.github.frankkwok.tij4.generics.coffee.Coffee;

/**
 * Page 534
 * Exercise 38: Create a simple Decorator system by starting with basic coffee, then providing decorators of steamed
 * milk, foam, chocolate, caramel and whipped cream.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class Decoration {
    public static void main(String[] args) {
        Coffee coffee = new Cappuccino();
        MilkDecorator milkDecorator = new MilkDecorator(coffee);
        FoamDecorator foamDecorator = new FoamDecorator(milkDecorator);
        ChocolateDecorator chocolateDecorator = new ChocolateDecorator(foamDecorator);
        CaramelDecorator caramelDecorator = new CaramelDecorator(chocolateDecorator);
        CreamDecorator creamDecorator = new CreamDecorator(caramelDecorator);

        milkDecorator.addMilk();
        foamDecorator.foam();
        chocolateDecorator.addChocolate();
        caramelDecorator.addCaramel();
        creamDecorator.addCream();
    }
}

class Decorator extends Coffee {
    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends Decorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addMilk() {
        System.out.println("This coffee has add milk");
    }
}

class FoamDecorator extends Decorator {
    public FoamDecorator(Coffee coffee) {
        super(coffee);
    }

    public void foam() {
        System.out.println("This coffee has form");
    }
}

class ChocolateDecorator extends Decorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addChocolate() {
        System.out.println("This coffee has add chocolate");
    }
}

class CaramelDecorator extends Decorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addCaramel() {
        System.out.println("This coffee has add caramel");
    }
}

class CreamDecorator extends Decorator {
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    public void addCream() {
        System.out.println("This coffee has add cream");
    }
}
