plugins {
  kotlin("jvm") version "1.6.10"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.test {
  useJUnitPlatform()
}
