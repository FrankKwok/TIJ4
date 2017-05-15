package com.github.frankkwok.tij4.typoinfo;

import com.github.frankkwok.tij4.typoinfo.factory.Factory;
import com.github.frankkwok.tij4.util.Null;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Page 435
 * Exercise 13: Use TypeCounter with the RegisteredFactories.java example in this chapter.
 * <p>
 * Page 438
 * Exercise 14: A constructor is a kind of factory method. Modify RegisteredFactories.java so that instead of using an
 * explicit factory, the class object is stored in the List, and newlnstance( ) is used to create each object.
 * <p>
 * Page 452
 * Exercise 24: Add Null Objects to RegisteredFactories.java.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 45; i++) {
            System.out.println(Part.createRandom());
        }
    }
}

class Part {
    private static Random random = new Random();
    static List<Factory<? extends Part>> partFactories = new ArrayList<>();

    static {
        partFactories.add(FuelFilter::new);
        partFactories.add(AirFilter::new);
        partFactories.add(CabinAirFilter::new);
        partFactories.add(OilFilter::new);
        partFactories.add(FanBelt::new);
        partFactories.add(PowerSteeringBelt::new);
        partFactories.add(GeneratorBelt::new);
        partFactories.add(NullPart::new);
    }

    static List<Class<? extends Part>> partClasses = new ArrayList<>();

    static {
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteeringBelt.class);
        partClasses.add(GeneratorBelt.class);
    }

    public static Part createRandom() {
        /*int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();*/

        int n = random.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {

}

class FuelFilter extends Filter {

}

class AirFilter extends Filter {

}

class CabinAirFilter extends Filter {

}

class OilFilter extends Filter {

}

class Belt extends Part {

}

class FanBelt extends Belt {

}

class GeneratorBelt extends Belt {

}

class PowerSteeringBelt extends Belt {

}

class NullPart extends Part implements Null {

}
