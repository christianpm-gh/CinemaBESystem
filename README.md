# Sistema de Reserva de Boletos de Cine

Este proyecto es un sistema **cliente-servidor** desarrollado en **Java**, diseñado para gestionar la reserva de boletos de cine. Todo el sistema funciona en consola, con una arquitectura orientada a objetos, múltiples clientes concurrentes, y una base de datos en **MySQL**.

---

## **Características Implementadas**
1. **Estructura del Proyecto**:
   - Separación en paquetes: `cliente`, `servidor`, y `common`.
   - Organización siguiendo el patrón de capas:
     - **Cliente**: Manejo de la interacción con el usuario.
     - **Servidor**: Lógica de negocio y conexión con la base de datos.
     - **Clases comunes**: Objetos de transferencia de datos (DTOs) y excepciones compartidas.

2. **Servidor**:
   - Capaz de manejar múltiples clientes concurrentes usando hilos (`Thread`).
   - Comunicación basada en **sockets**.
   - Responde a mensajes básicos enviados por los clientes.

3. **Cliente**:
   - Se conecta al servidor mediante sockets.
   - Permite al usuario enviar comandos y recibir respuestas.

4. **Base de Datos**:
   - Base de datos `cine_db` creada en MySQL.
   - Esquema básico con tablas para:
     - `usuarios`: Información básica de los usuarios.
     - `funciones`: Detalles de las funciones de cine.
     - `boletos`: Estado y asignación de asientos para las funciones.

---

## **Estructura del Proyecto**

```plaintext
com.portafolio_ciem.cine
├── cliente       # Código relacionado con el cliente.
│   ├── controladores  # Manejo de interacciones con el servidor.
│   ├── dto            # Clases para transferir datos al servidor.
│   ├── main           # Punto de entrada del cliente.
│   └── utils          # Herramientas específicas del cliente.
├── common        # Clases compartidas entre cliente y servidor.
│   ├── dto            # Objetos de transferencia comunes.
│   ├── excepciones    # Excepciones manejadas por ambas partes.
│   └── utils          # Utilidades compartidas.
└── servidor      # Código relacionado con la lógica del servidor.
    ├── config         # Configuración del servidor (e.g., base de datos).
    ├── controladores  # Manejo de solicitudes desde el cliente.
    ├── dto            # Clases para transferir datos hacia el cliente.
    ├── excepciones    # Manejo de errores y lógica de fallos.
    ├── main           # Punto de entrada del servidor.
    └── modelo
        ├── entidades  # Representación de tablas de la base de datos.
        ├── enums      # Enumeraciones para valores constantes.
        └── repositorio # Acceso a la base de datos.
        └── servicio    # Lógica de negocio del servidor.
