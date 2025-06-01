pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Multimodule sample"
include(":app")
include(":core:data")
include(":core:domain")
include(":core:network")
include(":core:datastore")
include(":core:designsystem")
include(":core:uicomponents")
include(":core:common")
include(":feature:feature1")
include(":feature:feature2")
