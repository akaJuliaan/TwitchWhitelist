import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
   kotlin("jvm") version "1.6.21"
   id("com.github.johnrengelman.shadow") version "2.0.4"
}

group = "de.jakkoble"
version = "1.1"

repositories {
   mavenCentral()
}

repositories {
   maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
   compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
   implementation(kotlin("stdlib-jdk8"))
   implementation("com.github.twitch4j:twitch4j:1.11.0")
   implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
   implementation("com.neovisionaries:nv-websocket-client:2.14")
}

java {
   toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
   testImplementation(kotlin("test"))
}

tasks.test {
   useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
   kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
   jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
   jvmTarget = "1.8"
}