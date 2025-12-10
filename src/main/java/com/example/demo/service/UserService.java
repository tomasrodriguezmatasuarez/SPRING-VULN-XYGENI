package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Servicio con consulta SQL vulnerable a inyección.
 */
@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Búsqueda INSEGURA: concatena el parámetro directamente en la SQL.
     *
     * Ejemplo de explotación:
     *   /api/users/search-unsafe?name=' OR '1'='1
     */
    public List<Map<String, Object>> findByNameUnsafe(String name) {
        String sql = "SELECT * FROM USERS WHERE username = '" + name + "'";
        return jdbcTemplate.queryForList(sql);
    }
}
