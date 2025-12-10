package com.example.demo.controller;

import com.example.demo.util.SensitiveConstants;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controlador con varios patrones vulnerables:
 *  - Exposición de datos sensibles en logs y respuestas.
 *  - Uso de servicio con SQL injection.
 */
@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/users/search-unsafe")
    public List<Map<String, Object>> searchUnsafe(@RequestParam("name") String name) {
        logger.info("Buscando usuarios con filtro no sanitizado: {}", name);
        return userService.findByNameUnsafe(name);
    }

    @GetMapping("/api/debug/secrets")
    public Map<String, String> debugSecrets() {
        // Endpoint que expone secretos hardcodeados (exposición de datos sensibles)
        Map<String, String> secrets = new HashMap<>();
        secrets.put("awsAccessKeyId", SensitiveConstants.AWS_ACCESS_KEY_ID);
        secrets.put("stripeSecretKey", SensitiveConstants.STRIPE_SECRET_KEY);
        secrets.put("dbPassword", SensitiveConstants.DB_PASSWORD);
        return secrets;
    }
}
