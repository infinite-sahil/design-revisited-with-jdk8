package org.somebody.dgnp.factory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
public interface Factory<T> extends Supplier<T> {

    static <P> Factory<P> createFactory(Supplier<P> circleSupplier) {
        final P singleton = circleSupplier.get();
        return () -> singleton;
    }


    static <C, T> Factory<T> createFactory(Function<C, T> function, C color) {
        return () -> function.apply(color);
    }

    /**
     * @return new instances
     */
    default T newInstance() {
        return get();
    }

    /**
     * @param numberOfInstanceToBeCreated
     * @return input number of instances of type <T>
     */
    default List<T> createNInstances(int numberOfInstanceToBeCreated) {
        return IntStream.range(0, numberOfInstanceToBeCreated)
                .mapToObj(i -> newInstance())
                .collect(Collectors.toList());
    }
}
