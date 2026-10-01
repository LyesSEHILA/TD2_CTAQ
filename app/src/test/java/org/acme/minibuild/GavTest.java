package org.acme.minibuild;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GavTest {

    // Regroupe les deux cas de triangulation (Q4-Q6) en un seul test
    // parametre : chaque ligne fournit une coordonnee en entree
    // et les trois valeurs attendues en sortie.
    @ParameterizedTest
    @CsvSource({
        "org.acme:lib-a:1.0.0, org.acme, lib-a, 1.0.0",
        "org.other:lib-c:3.0.0, org.other, lib-c, 3.0.0"
    })
    void parseExtractsGroupArtifactAndVersion(
            String coordinate, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(coordinate);
        assertEquals(expectedGroup, gav.group());
        assertEquals(expectedArtifact, gav.artifact());
        assertEquals(expectedVersion, gav.version());
    }
}