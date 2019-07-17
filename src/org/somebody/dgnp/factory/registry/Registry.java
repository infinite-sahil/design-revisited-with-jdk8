package org.somebody.dgnp.factory.registry;

import org.somebody.dgnp.factory.Factory;
import org.somebody.dgnp.factory.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Registry {


    Factory<? extends Shape> buildShapeFactory(final String shape);

    static <T extends Shape> Registry createRegistry(Consumer<Builder<T>> builderConsumer,
                                                     Function<String, Factory<T>> errorFunction) {
        final Map<String, Factory<T>> map = new HashMap<>();
        builderConsumer.accept(map::put);
        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}
