package org.somebody.dgnp.factory.playground;

import org.somebody.dgnp.factory.Factory;
import org.somebody.dgnp.factory.model.Circle;
import org.somebody.dgnp.factory.model.ColorType;

import java.util.List;

public class FactoryPlayground {


    public static void main(String[] args) {

        final Factory<Circle> circleFactory = Factory.createFactory(Circle::new);
        final Factory<Circle> greenCircleFactory = Factory.createFactory(Circle::new, ColorType.GREEN);
        // created 10 instances of circle
        final List<Circle> circles = circleFactory.createNInstances(4);
        System.out.println(greenCircleFactory.createNInstances(1));
        System.out.println(circleFactory.newInstance());
        System.out.println(circles);
    }
}
