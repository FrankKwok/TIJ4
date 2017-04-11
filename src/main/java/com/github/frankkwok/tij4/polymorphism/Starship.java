package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 235
 * Exercise 16: Following the example in Transmogrify.java, create a Starship class containing an AlertStatus reference
 * that can indicate three different states. Include methods to change the states.
 * <p>
 * 策略模式-Strategy Pattern
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class Starship {
    private AlertStatus alertStatus = new AlertStatus();

    public static void main(String[] args) {
        Starship starship = new Starship();
        starship.print();
        starship.change(new GeneralStatus());
        starship.print();
        starship.change(new EmergencyStatus());
        starship.print();
        starship.change(new CriticalStatus());
        starship.print();
    }

    private void change(AlertStatus alertStatus) {
        this.alertStatus = alertStatus;
    }

    private void print() {
        alertStatus.print();
    }
}

class AlertStatus {
    void print() {
        System.out.println("AlertStatus.print()");
    }
}

class GeneralStatus extends AlertStatus {
    @Override
    void print() {
        System.out.println("GeneralStatus.print()");
    }
}

class EmergencyStatus extends AlertStatus {
    @Override
    void print() {
        System.out.println("EmergencyStatus.print()");
    }
}

class CriticalStatus extends AlertStatus {
    @Override
    void print() {
        System.out.println("CriticalStatus.print()");
    }
}
