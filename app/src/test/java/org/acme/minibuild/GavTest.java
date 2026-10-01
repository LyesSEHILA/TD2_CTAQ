package org.acme.minibuild;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class GavTest {

    // Memes cas que precedemment, mais les valeurs viennent maintenant d'un fichier CSV externe plutot que d'etre codees dans l'annotation.
    @ParameterizedTest
    @CsvFileSource(resources = "/gav-test-cases.csv", numLinesToSkip = 1)
    void parseExtractsGroupArtifactAndVersion(
            String coordinate, String expectedGroup, String expectedArtifact, String expectedVersion) {
        Gav gav = Gav.parse(coordinate);
        assertEquals(expectedGroup, gav.group());
        assertEquals(expectedArtifact, gav.artifact());
        assertEquals(expectedVersion, gav.version());
    }
}