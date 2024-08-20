plugins {
  kotlin("jvm") version "2.0.10"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val junitVersion = "5.11.0"

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:$junitVersion")
  implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
}

tasks.test {
  useJUnitPlatform()
}
