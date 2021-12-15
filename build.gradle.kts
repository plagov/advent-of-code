plugins {
  kotlin("jvm") version "1.6.10"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.kotest:kotest-runner-junit5:5.0.2")
}

tasks.test {
  useJUnitPlatform()
}
