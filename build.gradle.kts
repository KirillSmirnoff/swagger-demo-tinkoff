import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.21"
	kotlin("plugin.spring") version "1.5.21"
//	kotlin("plugin.jpa") version "1.5.21"
	/*OpenApi Generator*/
	id("org.openapi.generator") version "5.4.0"
}

group = "ru.k2"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11


/*OpenApi Generator*/
openApiGenerate {
	generatorName.set("kotlin-spring")
//	httpUserAgent.set("restTemplate")
	inputSpec.set("$projectDir/src/main/resources/openapi/mk/openapi.yml")
	outputDir.set("$rootDir")
	apiPackage.set("ru.k2.swaggerdemotinkoff.api")
//	invokerPackage.set("ru.k2.swaggerdemotinkoff.invoker")
	modelPackage.set("ru.k2.swaggerdemotinkoff.model")
	groupId.set("ru.k2")
	id.set("swagger-tinkoff")
	version.set("0.0.10")
	configOptions.put("dateLibrary", "java8")
	configOptions.put("delegatePattern", "true")
//	configOptions.put("gradleBuildFile", "true")
//	configOptions.put("serverPort", "8085")
}

repositories {
	mavenCentral()
}

dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	/*OpenApi Generator*/
	implementation("org.openapitools:openapi-generator-gradle-plugin:5.4.0"){
		exclude(group = "org.slf4j", module = "slf4j-simple") // org.slf4j:slf4j-simple
	}

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.openApiGenerate {
	doLast{

//		/* переносит сгенерированные фалы из java подкаталога в подкаталог kotlin */
//		copy {
//			from("$rootDir/src/main/java/ru/k2/swaggerdemotinkoff")
//			into("$rootDir/src/main/kotlin/ru/k2/swaggerdemotinkoff")
//		}

		/* удаляет лишние папки, которые были сгенерированы */
		delete(
				"$rootDir/.openapi-generator",
				"$rootDir/src/main/kotlin/org",
//				"$rootDir/src/main/java/org"
//				,
//				"$rootDir/src/main/java"
		)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
