plugins {
  kotlin("jvm") version "1.9.21"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val junitVersion = "5.10.1"

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:$junitVersion")
  implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.test {
  useJUnitPlatform()
}
