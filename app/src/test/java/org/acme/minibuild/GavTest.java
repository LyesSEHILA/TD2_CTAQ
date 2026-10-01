package org.acme.minibuild;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GavTest {

    // Memes cas que precedemment (CsvSource), mais les valeurs viennent
    // maintenant d'un fichier CSV externe plutot que d'etre codees
    // dans l'annotation.
    @ParameterizedTest
    @CsvFileSource(resources = "/gav-test-cases.csv", numLinesToSkip = 1)
    void parseExtractsGroupArtifactAndVersion(
            String coordinate, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(coordinate);
        assertEquals(expectedGroup, gav.group());
        assertEquals(expectedArtifact, gav.artifact());
        assertEquals(expectedVersion, gav.version());
    }

    // Classes d'equivalence invalides : trop peu de segments, trop de
    // segments, et segment vide (au milieu ou en fin de chaine). Les
    // trois doivent lever la meme exception.
    @ParameterizedTest
    @ValueSource(strings = {
        "org.acme:lib-a",                  // trop peu de segments (2)
        "org.acme:lib-a:1.0.0:extra",       // trop de segments (4)
        "org.acme::1.0.0",                  // artifact vide
        "org.acme:lib-a:",                  // version vide
        ":lib-a:1.0.0"                      // group vide
    })
    void parseRejectsMalformedCoordinate(String malformed) {
        assertThrows(InvalidGavException.class, () -> Gav.parse(malformed));
    }
}