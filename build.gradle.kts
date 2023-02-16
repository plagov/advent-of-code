plugins {
  kotlin("jvm") version "1.8.10"
  id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val junitVersion = "5.9.2"

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:$junitVersion")
  implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf(
      "-Xuse-k2",
      "-Xbackend-threads=4"
    )
    jvmTarget = "11"
    languageVersion = "1.7"
  }
}
