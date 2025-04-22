plugins {
  id("fabric-loom") version "1.9-SNAPSHOT"
  id("maven-publish")
}

val modId = properties["mod_id"] as String
val artifactName = properties["artifact_name"] as String
val minecraftVersion = properties["minecraft_version"] as String

base {
  archivesName = "${artifactName}-fabric-${minecraftVersion}"
}

dependencies {
  minecraft("com.mojang:minecraft:${minecraftVersion}")
  mappings("net.fabricmc:yarn:${properties["mappings_version"]}:v2")
  modImplementation("net.fabricmc:fabric-loader:${properties["fabric_loader_version"]}")
  modImplementation("net.fabricmc.fabric-api:fabric-api:${properties["fabric_api_version"]}")
}

fabricApi {
  configureDataGeneration()
}

loom {
  splitEnvironmentSourceSets()

  runs {
    named("client") {
      runDir = "run/client"

      client()
    }
    named("server") {
      runDir = "run/server"

      server()
    }
  }

  mods {
    create(modId) {
      sourceSet("main")
    }
  }
}

java {
  toolchain.languageVersion = JavaLanguageVersion.of(21)

  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21

  withSourcesJar()
}

tasks.withType(JavaCompile::class.java).configureEach {
  options.encoding = "UTF-8"
  options.release = 21
}

tasks.processResources {
  filesMatching("fabric.mod.json") {
    filter(fun(line: String): String {
      return Regex("%([a-z_]+)%").replace(line, fun(match: MatchResult): String {
        return properties[match.groupValues[1]]?.toString() ?: match.value
      })
    })
  }
}

tasks.named<Jar>("jar") {
  from("LICENSE") {
    rename {
      "LICENSE-${modId}"
    }
  }
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      groupId = project.group.toString()
      artifactId = project.base.archivesName.get()
      version = project.version.toString()

      from(components["java"])
    }
  }

  repositories {
    maven {
      name = "GithubPackages"
      url = uri(properties["github_packages_url"].toString())
      credentials {
        username = System.getenv("GITHUB_ACTOR")
        password = System.getenv("GITHUB_TOKEN")
      }
    }
    mavenLocal()
  }
}
