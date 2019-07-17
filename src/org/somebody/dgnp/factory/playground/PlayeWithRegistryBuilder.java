package org.somebody.dgnp.factory.playground;

import org.somebody.dgnp.factory.Factory;
import org.somebody.dgnp.factory.model.Rectangle;
import org.somebody.dgnp.factory.model.Shape;
import org.somebody.dgnp.factory.model.Triangle;
import org.somebody.dgnp.factory.registry.Builder;
import org.somebody.dgnp.factory.registry.Registry;

import java.util.function.Consumer;

public class PlayeWithRegistryBuilder {

    public static final String RECTANGLE = "rectangle";
    public static final String TRIANGLE = "triangle";

    public static void main(String[] args) {

        final Consumer<Builder<Shape>> rectangleBuilderConsumer =
                builder -> builder.register(RECTANGLE, Rectangle::new);

        final Consumer<Builder<Shape>> triangleBuilderConsumer =
                builder -> builder.register(TRIANGLE, Triangle::new);

        Consumer<Builder<Shape>> combinedConsumer = rectangleBuilderConsumer.andThen(triangleBuilderConsumer);

        final Registry registry = Registry.createRegistry(combinedConsumer);

        Factory<? extends Shape> recFactory = registry.buildShapeFactory(RECTANGLE);
        Factory<? extends Shape> triFactory = registry.buildShapeFactory(TRIANGLE);
        System.out.println("Rectangle here it is : " + recFactory.newInstance());
        System.out.println("Triangle here it is : " + triFactory.newInstance());
    }
}
