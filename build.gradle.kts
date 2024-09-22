group = "ta.com.sepi"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.google.cloud.tools.jib") version "3.4.3"
	kotlin("plugin.jpa") version "1.9.25"
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("io.micrometer:micrometer-registry-prometheus")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("io.mockk:mockk:1.13.12")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

jib {
	to {
		image = "ananthpitchiah/med-search"
		tags = setOf("$version", "$version")
		auth {
			username = System.getenv("ananthpitchiah")
			password = System.getenv("anP!vct1924")
		}
	}
	container {
		labels = mapOf(
			"maintainer" to "Ananth Pitchiah <ananth.pitchiah.95@gmail.com>",
			"org.opencontainers.image.title" to "med-search",
			"org.opencontainers.image.description" to "Service to search medicines",
			"org.opencontainers.image.version" to "$version",
			"org.opencontainers.image.authors" to "Ananth Pitchiah <ananth.pitchiah.95@gmail.com>>",
			"org.opencontainers.image.url" to "https://hub.docker.com/r/ananthpitchiah/med-search",
			"org.opencontainers.image.vendor" to "https://hub.docker.com/u/ananthpitchiah",
			"org.opencontainers.image.licenses" to "MIT"
		)
		jvmFlags = listOf(
			"-server",
			"-Djava.awt.headless=true",
			"-XX:InitialRAMFraction=2",
			"-XX:MinRAMFraction=2",
			"-XX:MaxRAMFraction=2",
			"-XX:+UseG1GC",
			"-XX:MaxGCPauseMillis=100",
			"-XX:+UseStringDeduplication"
		)
		workingDirectory = "/webservice"
		ports = listOf("8900")
	}
}
