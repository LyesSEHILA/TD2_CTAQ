package org.acme.minibuild;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryStorageTest {

    private IStorage storage;

    @BeforeEach
    void init() {
        storage = new InMemoryStorage();
    }

    // Verifie qu'un artefact publie via put() est bien retrouve via get(),
    // avec la meme coordonnee.
    @Test
    void getReturnsArtifactPreviouslyPut() {
        Gav gav = Gav.parse("org.acme:lib-a:1.0.0");
        Artifact artifact = new Artifact(gav, java.util.Set.of());

        storage.put(gav, artifact);

        assertEquals(Optional.of(artifact), storage.get(gav));
    }

    // Verifie qu'une coordonnee absente renvoie Optional.empty(),
    // plutot que null ou une exception.
    @Test
    void getReturnsEmptyForUnknownGav() {
        Gav gav = Gav.parse("org.acme:lib-unknown:1.0.0");

        assertTrue(storage.get(gav).isEmpty());
    }
}