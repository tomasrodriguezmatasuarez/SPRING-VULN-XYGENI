# SPRING-VULN-XYGENI

Proyecto de ejemplo Spring Boot con múltiples vulnerabilidades intencionadas
para ser analizado con la plataforma Xygeni.

## Estructura principal

- `pom.xml` – dependencias (incluye librerías vulnerables, licencias problemáticas y repos HTTP).
- `src/main/java/com/example/demo`
  - `DemoApplication.java`
  - `config/SecurityConfig.java` – configuración con acceso abierto.
  - `controller/UserController.java` – exposición de datos sensibles y uso de SQL insegura.
  - `repository/UserRepository.java`
  - `service/UserService.java` – consulta vulnerable a inyección SQL.
  - `util/SensitiveConstants.java` – credenciales hardcodeadas.
- `src/main/resources`
  - `application.properties` – HTTP sin TLS y credenciales en claro.
  - `data.sql` – datos de ejemplo.
  - `notes_tls.md` – notas explicando decisiones inseguras.

## Vulnerabilidades cubiertas (solo Spring Boot)

1. **Dependencias vulnerables (CVE)** – versiones antiguas de Spring Boot, Log4J, Jackson, commons-collections.
2. **Paquetes maliciosos** – repositorio HTTP no confiable y dependencia `com.malicious:evil-lib`.
4. **Exposición de datos sensibles** – endpoint `/api/debug/secrets` y credenciales en properties.
5. **Inyección SQL** – método `findByNameUnsafe` en `UserService` y endpoint `/api/users/search-unsafe`.
7. **Protocolos inseguros** – servidor solo HTTP, referencias a TLS 1.0 en `notes_tls.md`.
8. **Hardcodeo de credenciales** – constantes en `SensitiveConstants` y propiedades de datasource.
10. **Licencias de dependencias no permitidas** – inclusión de `itextpdf` (AGPL) para prueba.
11. **Control de acceso insuficiente** – `SecurityConfig` permite acceso a todos los endpoints.

Este código NO debe usarse en producción.
