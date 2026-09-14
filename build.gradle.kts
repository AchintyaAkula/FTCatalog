plugins {
    `maven-publish`
    signing
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

group = "io.github.achintyaakula.ftcatalog"
version = "0.0.1"

gradlePlugin {
    plugins {
        create("FTCatalog") {
            id = "io.github.achintyaakula.ftcatalog"
            implementationClass = "FTCatalogPlugin"
            displayName = "FTCatalog"
            description = "Easy Gradle Management with Version Catalogs"
        }
    }
}

publishing {
    publications {
        withType<MavenPublication>().configureEach {
            pom {
                name.set("FTCatalog")
                description.set("FTC Version Catalogs")
                url.set("https://github.com/AchintyaAkula/FTCatalog")

                developers {
                    developer {
                        id.set("achintyaakula")
                        name.set("Achintya Akula")
                        email.set("achintya.akula@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/AchintyaAkula/FTCatalog.git")
                    developerConnection.set("scm:git:ssh://github.com/AchintyaAkula/FTCatalog.git")
                    url.set("https://github.com/AchintyaAkula/FTCatalog")
                }
            }
        }

        create<MavenPublication>("catalog-ftc") {
            artifactId = "catalog-ftc"
            artifact(file("catalogs/ftc.versions.toml")) {
                extension = "toml"
            }
        }

        create<MavenPublication>("catalog-pedro") {
            artifactId = "catalog-pedro"
            artifact(file("catalogs/pedro.versions.toml")) {
                extension = "toml"
            }
        }

        create<MavenPublication>("catalog-dairy") {
            artifactId = "catalog-dairy"
            artifact(file("catalogs/dairy.versions.toml")) {
                extension = "toml"
            }
        }
    }

    repositories {
        maven {
            name = "MavenCentral"
            url = uri("https://sonatype.org")

            credentials {
                username = providers.gradleProperty("mavenCentralUsername").orNull
                password = providers.gradleProperty("mavenCentralPassword").orNull
            }
        }
    }
}

signing {
    sign(publishing.publications)
}
