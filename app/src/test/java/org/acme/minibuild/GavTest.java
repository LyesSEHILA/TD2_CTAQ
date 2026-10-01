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
}