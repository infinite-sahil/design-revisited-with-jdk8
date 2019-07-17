package org.somebody.dgnp.factory.playground;

import org.somebody.dgnp.factory.Factory;
import org.somebody.dgnp.factory.model.Rectangle;
import org.somebody.dgnp.factory.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SwitchRegistry switchRegistry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) switchRegistry.buildShapeFactory("rectangle");
        System.out.println("New rectangle : " + rectangleFactory.newInstance());
    }
}
