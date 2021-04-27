package com.example.demo.configuration;

import com.example.demo.dao.FakeDao;
import com.example.demo.model.User;
import com.example.demo.repository.FakeRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {

    @Value("${application.path}")
    public String path;

    @Bean
    public FakeDao fakeDao() {
        return new FakeDao("http://google.fr/dao");
    }

    @Bean
    public FakeRepository fakeRepository(String jsonContent) {
        Gson gson = new Gson();
        User[] users = gson.fromJson(jsonContent, User[].class);
        return new FakeRepository(new ArrayList<>(Arrays.asList(users)));
    }

    @Bean
    public String jsonContent() throws IOException {
        return "[\n" +
                "  {\n" +
                "    \"lastname\": \"guemas\",\n" +
                "    \"name\": \"greg\",\n" +
                "    \"age\": 24\n" +
                "  }\n" +
                "]";
    }

}
