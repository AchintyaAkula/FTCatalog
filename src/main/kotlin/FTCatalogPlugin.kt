import org.gradle.api.Plugin
import org.gradle.api.initialization.Settings

class FTCatalogPlugin : Plugin<Settings> {
    override fun apply(target: Settings) {
        val version = "0.0.1"

        target.dependencyResolutionManagement {
            versionCatalogs {
                create("ftc") {
                    from("io.github.achintyaakula.ftcatalog:catalog-ftc:$version")
                }
                create("pedro") {
                    from("io.github.achintyaakula.ftcatalog:catalog-pedro:$version")
                }
                create("dairy") {
                    from("io.github.achintyaakula.ftcatalog:catalog-dairy:$version")
                }
            }
        }
    }
}