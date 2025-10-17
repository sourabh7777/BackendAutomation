plugins {
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Cucumber 7 + Spring
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    testImplementation("io.cucumber:cucumber-spring:7.14.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.14.0")
    testImplementation("io.cucumber:cucumber-junit:7.14.0")
    testImplementation("io.cucumber:messages:17.0.0")

    // Extent Report for Cucumber 7
    testImplementation("tech.grasshopper:extentreports-cucumber7-adapter:1.5.1")
    testImplementation("com.google.protobuf:protobuf-java:3.21.12")

    // JUnit 4 + 5
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Spring Boot test support
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.test {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", findProperty("spring.profiles.active") ?: "stage")
    systemProperty("api.key", findProperty("api.key") ?: "")
}
