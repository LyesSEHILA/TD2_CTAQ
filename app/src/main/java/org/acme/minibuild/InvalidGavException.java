package org.acme.minibuild;

// Levee quand une coordonnee ne respecte pas le format "group:artifact:version"
// (mauvais nombre de segments, ou un segment vide).
public class InvalidGavException extends RuntimeException {

    public InvalidGavException(String coordinate) {
        super("Coordonnee GAV invalide : \"" + coordinate + "\"");
    }
}