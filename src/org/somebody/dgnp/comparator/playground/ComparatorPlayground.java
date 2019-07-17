package org.somebody.dgnp.comparator.playground;

import org.somebody.dgnp.comparator.Comparator;
import org.somebody.dgnp.comparator.model.Person;

public class ComparatorPlayground {

    public static void main(String[] args) {

        final Person tom = new Person("tom", 40);
        final Person dik = new Person("dik", 33);
        final Person herry = new Person("herry", 10);
        final Person tomB = new Person("tom", 50);

        // compare by name, if name is same then compare it by age
        final Comparator<Person> personComparator =
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge);

        System.out.println("Tom is older than tomb " + (personComparator.compare(tom, tomB) > 0));
        System.out.println("Tom is older than dik " + (personComparator.compare(tom, dik) > 0));
        System.out.println("herry is older than dik " + (personComparator.compare(herry, dik) > 0));
    }

}
