package datastructures;

import java.util.HashSet;
import java.util.Set;

public class Markup {
    private final Set<Integer> valueBuffer;

    public Markup() {
        this.valueBuffer = new HashSet<>();
    }

    public void addValue(int value) {
        this.valueBuffer.add(value);
    }

    public boolean containsValue(int value) {
        return this.valueBuffer.contains(value);
    }

    public void removeValue(int value) {
        this.valueBuffer.remove(value);
    }
}
