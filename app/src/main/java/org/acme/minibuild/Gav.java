package org.acme.minibuild;

public class Gav {

    private final String group;
    private final String artifact;
    private final String version;

    private Gav(String group, String artifact, String version) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    // Decoupe une chaine "group:artifact:version" en ses trois parties.
    // Leve InvalidGavException si le format n'est pas respecte : mauvais
    // nombre de segments, ou un segment vide.
    public static Gav parse(String coordinate) {
        String[] parts = coordinate.split(":");
        if (parts.length != 3 || parts[0].isEmpty() || parts[1].isEmpty() || parts[2].isEmpty()) {
            throw new InvalidGavException(coordinate);
        }
        return new Gav(parts[0], parts[1], parts[2]);
    }

    public String group() {
        return group;
    }

    public String artifact() {
        return artifact;
    }

    public String version() {
        return version;
    }
}