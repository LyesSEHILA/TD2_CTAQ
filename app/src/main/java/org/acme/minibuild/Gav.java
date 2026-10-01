package org.acme.minibuild;

public class Gav {
    private final String group;

    private Gav(String group) {
        this.group = group;
    }

    public static Gav parse(String coordinate) {
        return new Gav("org.acme");
    }

    public String group() {
        return group;
    }
}