plugins {
	java
	id("org.springframework.boot") version "2.5.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	/*OpenApi Generator*/
	id("org.openapi.generator") version "5.4.0"
}

group = "ru.k2"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11


/*OpenApi Generator*/
openApiGenerate {
	generatorName.set("spring")
	inputSpec.set("$projectDir/src/main/resources/openapi/mk/openapi.yml")
	outputDir.set("$rootDir")
	apiPackage.set("ru.k2.swaggerdemotinkoff.api")
	modelPackage.set("ru.k2.swaggerdemotinkoff.model")
	configOptions.put("dateLibrary", "java8")
	configOptions.put("delegatePattern", "true")
}

repositories {
	mavenCentral()
}

dependencies {
	/*WEB*/
	implementation("org.springframework.boot:spring-boot-starter-web")

	/*DATA*/
//	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	/*OpenApi Generator*/
	implementation("org.openapitools:openapi-generator-gradle-plugin:5.4.0"){
		exclude(group = "org.slf4j", module = "slf4j-simple") // org.slf4j:slf4j-simple
	}
	implementation("org.openapitools:jackson-databind-nullable:0.2.1")

	/*TEST*/
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	/*OTHER*/
	developmentOnly("org.springframework.boot:spring-boot-devtools")
}

tasks {
	withType<JavaCompile> {
		options.encoding = "UTF-8"
	}
	withType<Test> {
		useJUnitPlatform()
	}
}

tasks.openApiGenerate {
	doLast{
		/* удаляет лишние папки после генерации */
		delete(
				"$rootDir/.openapi-generator",
				"$rootDir/src/main/java/org"
		)
	}
}
