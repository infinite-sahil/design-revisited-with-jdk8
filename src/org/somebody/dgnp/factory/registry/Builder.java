package org.somebody.dgnp.factory.registry;

import org.somebody.dgnp.factory.Factory;

public interface Builder<T> {

    void register(String label, Factory<T> factory);

}
