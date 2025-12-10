# Notas sobre TLS (deliberadamente inseguras para la PoC)

Este proyecto de ejemplo está configurado para:

- Aceptar únicamente HTTP sin TLS en el puerto 8080.
- Incluir referencias a versiones antiguas como TLS 1.0 y suites de cifrado débiles.
- No usar cabeceras de seguridad como HSTS, X-Content-Type-Options, etc.

Todo ello se mantiene así a propósito para que Xygeni pueda detectarlo
como uso de protocolos inseguros o configuración de cifrado débil.
