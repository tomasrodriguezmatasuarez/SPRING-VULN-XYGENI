package com.example.demo.util;

/**
 * Clase que agrupa credenciales y secretos hardcodeados
 * con fines de demostración para la PoC.
 */
public class SensitiveConstants {

    // Valores con formato típico para que los detectores de secretos los marquen.
    public static final String AWS_ACCESS_KEY_ID = "AKIAFAKEACCESSKEY123456";
    public static final String AWS_SECRET_ACCESS_KEY = "fake/secret/key/for-demo-only-CHANGE-ME";
    public static final String STRIPE_SECRET_KEY = "sk_live_1234567890_fake_secret_key";
    public static final String DB_PASSWORD = "SuperInsecurePassword!";
}
