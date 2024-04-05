package org.learning.wishlist;

import java.util.Objects;

public class Present implements Comparable<Present> {
    String name;

    public Present(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Present present = (Present) o;
        return Objects.equals(name, present.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Present o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
