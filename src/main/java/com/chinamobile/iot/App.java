package com.chinamobile.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class App {
    public static void main(String... args) {
        new SpringApplication(App.class).run(args);
    }
}
