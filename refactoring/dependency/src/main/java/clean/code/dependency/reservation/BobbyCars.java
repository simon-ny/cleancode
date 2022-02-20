package clean.code.dependency.reservation;

import java.util.HashMap;
import java.util.Map;

enum BobbyCars {
    RED("red", 10),
    BLUE("blue", 0),
    YELLOW("yellow", 0);

    private static final Map<String, BobbyCars> BY_NAME = new HashMap<>();

    static {
        for (BobbyCars b : values()) {
            BY_NAME.put(b.name, b);
        }
    }

    public final String name;
    public final int availableUnits;

    private BobbyCars(String name, int availableUnits) {
        this.name = name;
        this.availableUnits = availableUnits;
    }

    public static BobbyCars byName(String name) {
        return BY_NAME.get(name);
    }
}
