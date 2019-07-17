package org.somebody.dgnp.factory.registry;

import org.somebody.dgnp.factory.Factory;
import org.somebody.dgnp.factory.model.Rectangle;
import org.somebody.dgnp.factory.model.Shape;
import org.somebody.dgnp.factory.model.Square;
import org.somebody.dgnp.factory.model.Triangle;

public class SwitchRegistry {


    public Factory<? extends Shape> buildShapeFactory(final String shape) {

        switch (shape) {
            case "square":
                return () -> new Square();
            case "triangle":
                return () -> new Triangle();
            case "rectangle":
                return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Invalid Shape found : " + shape);
        }
    }

}
