plugins {
    java
    id("org.springframework.boot") version "3.3.2"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

buildscript {
    repositories {
        mavenLocal()
        maven {
            setUrl("https://maven.aliyun.com/repository/public/")
        }
        maven {
            setUrl("https://mirrors.huaweicloud.com/repository/maven/")
        }
        mavenCentral()
    }
}

repositories {
    mavenLocal()
    maven {
        setUrl("https://maven.aliyun.com/repository/public/")
    }
    maven {
        setUrl("https://mirrors.huaweicloud.com/repository/maven/")
    }
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    //mybatis-plus
    implementation("com.baomidou:mybatis-plus-spring-boot3-starter:3.5.7")
    //mybatis-plus-generator
    implementation("com.baomidou:mybatis-plus-generator:3.5.7")
    //freemarker模板
    implementation("org.freemarker:freemarker:2.3.33")
    //mybatis-plus-join
    implementation("com.github.yulichang:mybatis-plus-join-boot-starter:1.4.13")
    //knife4j
    implementation("com.github.xiaoymin:knife4j-openapi3-jakarta-spring-boot-starter:4.4.0")
    //redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    //fastjson2
    implementation("com.alibaba.fastjson2:fastjson2:2.0.51")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
