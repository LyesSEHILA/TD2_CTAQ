package org.acme.minibuild;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GavTest {

    // Vérifie que Gav.parse extrait correctement le groupe
    // à partir d'une chaîne "group:artifact:version".
    @Test
    void parseExtractsGroup() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        assertEquals("org.acme", gav.group());
    }


    // Triangulation : un second cas, avec des valeurs différentes,
    // pour forcer un vrai découpage de la chaîne plutôt qu'une
    // valeur codée en dur. On vérifie cette fois les trois champs.
    @Test
    void parseExtractsGroupArtifactAndVersion() {
        Gav gav = Gav.parse("org.other:lib-c:3.0.0");
        assertEquals("org.other", gav.group());
        assertEquals("lib-c", gav.artifact());
        assertEquals("3.0.0", gav.version());
    }
    
}