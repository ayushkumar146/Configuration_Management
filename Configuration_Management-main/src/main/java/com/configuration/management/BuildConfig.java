package com.configuration.management;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration  // 📦 This tells Spring: "Hey, this is a special class that holds config values"
@ConfigurationProperties(prefix = "build")
// 🏗️ This means:
// "Go to application.yaml, find the section that starts with 'build:',
// and put those values inside this class."
public class BuildConfig {

    // 🔑 These are just boxes (variables) where values will be stored.

    private String id;       // this will get value from build.id in yaml
    private String version;  // this will get value from build.version in yaml
    private String name;     // this will get value from build.name in yaml
    private String type;     // this will get value from build.type in yaml

    // 🛠️ These getters/setters are like doors 🚪 to put values in and take them out.

    public String getId() {
        return id; // 🎁 when you ask for id, it gives you build.id from yaml
    }

    public void setId(String id) {
        this.id = id; // 🏗️ Spring uses this to put yaml value into the box
    }

    public String getVersion() {
        return version; // 🎁 gives you build.version
    }

    public void setVersion(String version) {
        this.version = version; // 🏗️ Spring puts yaml value here
    }

    public String getName() {
        return name; // 🎁 gives you build.name
    }

    public void setName(String name) {
        this.name = name; // 🏗️ Spring puts yaml value here
    }

    public String getType() {
        return type; // 🎁 gives you build.type
    }

    public void setType(String type) {
        this.type = type; // 🏗️ Spring puts yaml value here
    }
}
