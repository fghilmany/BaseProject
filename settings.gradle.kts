pluginManagement {
    repositories {
        google()
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

rootProject.name = "BaseProject"
include(":androidApp")
include(":feature:moviedetail:domain")
include(":feature:moviedetail:api")
include(":feature:moviedetail:apiinfra")
include(":feature:moviedetail:cache")
include(":feature:moviedetail:cacheinfra")
include(":feature:moviedetail:composite")
include(":feature:moviedetail:presentation")
include(":feature:moviedetail:ui")
include(":common")
include(":feature:movielist:domain")
include(":feature:movielist:api")
include(":feature:movielist:apiinfra")
include(":feature:movielist:presentation")
include(":feature:movielist:ui")
include(":core:rest:retrofit")
include(":core:sqlite:room")
