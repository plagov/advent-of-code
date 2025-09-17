plugins {
  kotlin("jvm") version "2.0.10"
}

group = "io.plagov"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val junitVersion = "5.13.4"

dependencies {
  implementation("org.junit.jupiter:junit-jupiter:$junitVersion")
  implementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  useJUnitPlatform()
}
