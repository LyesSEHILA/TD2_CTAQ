# Task list — minibuild

[X] 1- Gav : parser une coordonnée group:artifact:version
    [X] 1.1- cas valide : découpage en group/artifact/version
    [X] 1.2- cas invalide : mauvais nombre de segments (trop peu / trop)
    [X] 1.3- cas invalide : segment vide (group, artifact ou version)
[ ] 2- InMemoryStorage : stockage clé-valeur (Gav -> Artifact)
[ ] 3- BufferedLineReader : lecture ligne à ligne d'un fichier de build
[ ] 4- LineBasedPomParser : parser un fichier de build en Project
[ ] 5- StorageBasedRegistry : publier / rechercher des artefacts
[ ] 6- AllVersionsResolver : résoudre la fermeture transitive des dépendances
[ ] 7- BuildTool : orchestrer parse + resolve
