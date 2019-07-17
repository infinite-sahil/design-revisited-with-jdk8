package org.somebody.dgnp.comparator;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {


    int compare(T t1, T t2);


    default Comparator<T> thenComparing(Comparator<T> otherComparator) {
        Objects.requireNonNull(otherComparator);
        return (T p1, T p2) -> {
            int result = this.compare(p1, p2);
            if (result == 0)
                result = otherComparator.compare(p1, p2);

            return result;
        };
    }

    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        final Comparator<T> other = comparing(keyExtractor);
        return thenComparing(other);
    }

    static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            final U s1 = keyExtractor.apply(p1);
            final U s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }
}
