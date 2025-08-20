//// This line says: "This class belongs to a package (like a folder) called com.configuration.management".
//// Packages help us organize our code into boxes so we don’t get confused.
//package com.configuration.management;
//
//// This line lets us use @Value, which is a Spring Boot magic tool
//// to grab values from application.properties or application.yaml.
//import org.springframework.beans.factory.annotation.Value;
//
//// This line lets us use @GetMapping and @RestController
//// which are needed to make APIs (web links our app can respond to).
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//// This tells Spring Boot: "Hey, this class is a REST controller."
//// REST controller = it listens to the web (HTTP) and answers back with data (usually text or JSON).
//@RestController
//public class BuildInfoController {  // This is our class. Think of it like a toy robot that answers questions.
//
//    // @Value("${build.id}") means: Go look into application-dev.yaml (or properties file).
//// Find the key build.id and put its value inside buildId variable.
////    @Value("${build.id}")
////    private String buildId;  // This variable stores the build ID (like a number tag for our app).
////
////    // Same thing here: find build.version in YAML and put it inside buildVersion variable.
////    @Value("${build.version}")
////    private String buildVersion;  // This keeps track of which version the app is (like 1.0, 1.2.3, etc.).
////
////    // Again: find build.name in YAML and save it here.
////    @Value("${build.name}")
////    private String buildName;  // This is just a friendly name for the build (like "Dev-Production-Build").
//
//    @Value("${build.id:default-id}")
//    private String buildId;
//
//    @Value("${build.version:0.0.0}")
//    private String buildVersion;
//
//    @Value("${build.name:Unknown}")
//    private String buildName;
//
//    // This says: When someone visits http://localhost:8080/build-info, run this method.
//    @GetMapping("/build-info")
//    public String getBuildInfo() {  // This method creates a message about our build info.
//
//// It takes the three variables (id, version, name) and joins them into one string.
//// Example: "Build ID: 101, Version: 1.2.3, Name: Dev-Production-Build"
//        return "Build ID: " + buildId + ", Version: " + buildVersion + ", Name: " + buildName;
//
////        NOTE:- If we donot provide any profile in application.yaml then it would by default fetch the values of application.yaml.
//    }
//}



// Q1 how does @value knows from which of the yaml it has to take values:-
//Great question 👏👏 this is where **Spring Profiles** come into play.
//Let’s break it down like you’re 10 again 👦:
//
//---
//
//### 🟢 How does Spring know which `application-*.yaml` to use?
//
//1. **Default file** → If you don’t say anything, Spring Boot always reads from:
//
//   * `application.properties` OR
//   * `application.yaml`
//
//   👉 This is the "base recipe" for your app.
//
//---
//
//2. **Profile-specific files** → If you have:
//
//   * `application-dev.yaml`
//   * `application-test.yaml`
//   * `application-prod.yaml`
//
//   These are like "different costumes" 🎭 for your app depending on where it runs:
//
//   * `dev` = development (your laptop, testing stuff)
//   * `test` = testing (QA team)
//   * `prod` = production (real users)
//
//---
//
//3. **How do we tell Spring which one to use?**
//   We activate a **profile**.
//
//   Example:
//   In your **application.yaml** (the base file), you can say:
//
//   ```yaml
//   spring:
//     profiles:
//       active: dev
//   ```
//
//   👉 This means "Spring, please also load `application-dev.yaml`".
//
//---
//
//4. **Other ways to choose profile**:
//
//   * Using **command line** when you run your app:
//
//     ```bash
//     java -jar myapp.jar --spring.profiles.active=dev
//     ```
//   * Or inside your **IDE (IntelliJ/Eclipse)**: add `--spring.profiles.active=dev` in program arguments.
//   * Or even in **environment variables**:
//
//     ```bash
//     export SPRING_PROFILES_ACTIVE=dev
//     ```
//
//---
//
//### 🟢 What happens when a profile is active?
//
//* First, Spring loads the **base application.yaml** (common settings).
//* Then it loads the **profile file** (like `application-dev.yaml`).
//* If there’s a clash, the **profile file wins** 🎯.
//
//---
//
//👉 So in your case:
//When you use `@Value("${build.id}")`, Spring looks into the **active profile file** (`application-dev.yaml`) because you told it `spring.profiles.active=dev`.
//
//---
//
//⚡ In short:
//
//* `application.yaml` = default values.
//* `application-dev.yaml` = special values for dev.
//* Which one is used depends on **spring.profiles.active**.
//
//---
//

//--------------------by using @configuration annotation----------------------
package com.configuration.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildInfoController {

    private final BuildConfig buildConfig;

    // inject BuildConfig using constructor
    public BuildInfoController(BuildConfig buildConfig) {
        this.buildConfig = buildConfig;
    }

    @GetMapping("/build-info")
    public String getBuildInfo() {
        return "Build ID: " + buildConfig.getId() +
                ", Version: " + buildConfig.getVersion() +
                ", Name: " + buildConfig.getName() +
                ", Type: " + buildConfig.getType();
    }



}
