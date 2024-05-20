package com.ipartek.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class DatabaseController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-database")
    public ResponseEntity<String> testDatabase() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                return ResponseEntity.ok("Connection to database successful!");
            } else {
                return ResponseEntity.status(500).body("Failed to connect to database!");
            }
        } catch (SQLException e) {
            return ResponseEntity.status(500).body("Database connection error: " + e.getMessage());
        }
    }
}
