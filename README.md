# Desafio SpringBoot - RESTful API de ForoAlura

Con la resolución del desafío Foro Hub, pude experimentar directamente el papel de un desarrollador back-end en el día a día, creando una API REST. Sin duda es una parte esencial del programa ONE, donde tuve la oportunidad de aplicar conceptos avanzados de Java y Spring Boot, como la creación de endpoints, implementación de capas de seguridad, entre otros.

##Explicacion del proyecto
En este proyecto, se realiza una aplicación backend RESTful API utilizando SpringBoot con Java, que tiene como objetivo formar parte de un proyecto de un Foro de dudas y respuestas. Su función principal implementar los métodos HTTP estándar (GET, POST, PUT, DELETE, etc.) para realizar operaciones sobre los recursos. Ademas implementar las medidas de seguridad apropiadas para que las peticiones se cumplan siempre y cuando se tenga el correcto acceso de sesión y generado un Token JWT.

## Características Principales
- **Endpoints RESTful**: Implementación de los métodos HTTP estándar para CRUD de los recursos.
- **Seguridad**: Integración de autenticación y autorización con JWT.
- **Manejo de Errores**: Manejo adecuado de excepciones y mensajes de error personalizados.
- **Base de Datos**: Conexión y operaciones con una base de datos MySQL.
- **Validación de Datos**: Validación de las entradas de datos con anotaciones de Java.

## Tecnologías Utilizadas
- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para crear aplicaciones basadas en Spring.
- **Spring Security**: Para la implementación de medidas de seguridad.
- **JWT (JSON Web Token)**: Para la gestión de la autenticación y autorización.
- **MySQL**: Base de datos relacional.
- **Hibernate**: ORM para manejar la persistencia de datos.
- **Maven**: Herramienta de gestión de proyectos y dependencias.


# Endpoints

## UsuarioController

### Registrar Usuario
- **Endpoint**: `/login/register`
- **Método HTTP**: `POST`
- **Descripción**: Registra un nuevo usuario.
- **Request Body**: `DatosRegistroUsuario`
- **Response**: Usuario registrado con éxito o mensaje de error si el usuario ya existe.

---

## TopicoController

### Registrar Tópico
- **Endpoint**: `/topico`
- **Método HTTP**: `POST`
- **Descripción**: Registra un nuevo tópico.
- **Request Body**: `DatosRegistroTopico`
- **Response**: Mensaje de éxito.

### Listado de Tópicos
- **Endpoint**: `/topico`
- **Método HTTP**: `GET`
- **Descripción**: Obtiene una lista paginada de tópicos.
- **Response**: Página de `DatosListaTopicos`.

### Detallar Tópico
- **Endpoint**: `/topico/{id}`
- **Método HTTP**: `GET`
- **Descripción**: Obtiene los detalles de un tópico específico.
- **Path Variable**: `id` (ID del tópico)
- **Response**: Detalles del tópico, usuario y curso relacionados.

### Actualizar Tópico
- **Endpoint**: `/topico/{id}`
- **Método HTTP**: `PUT`
- **Descripción**: Actualiza un tópico existente.
- **Path Variable**: `id` (ID del tópico)
- **Request Body**: `DatosActualizacionTopico`
- **Response**: Detalles del tópico actualizado.

### Eliminar Tópico
- **Endpoint**: `/topico/{id}`
- **Método HTTP**: `DELETE`
- **Descripción**: Elimina un tópico existente.
- **Path Variable**: `id` (ID del tópico)
- **Response**: No content.

---

## RespuestaController

### Registrar Respuesta
- **Endpoint**: `/topico/respuesta`
- **Método HTTP**: `POST`
- **Descripción**: Registra una nueva respuesta.
- **Request Body**: `DatosRegistroRespuestas`
- **Response**: Mensaje de éxito.

### Listado de Respuestas por Tópico
- **Endpoint**: `/topico/{id}/respuestas`
- **Método HTTP**: `GET`
- **Descripción**: Obtiene una lista de respuestas para un tópico específico.
- **Path Variable**: `id` (ID del tópico)
- **Response**: Lista de `DatosListaRespuesta`.

### Actualizar Respuesta
- **Endpoint**: `/topico/respuesta/{id}`
- **Método HTTP**: `PUT`
- **Descripción**: Actualiza una respuesta existente.
- **Path Variable**: `id` (ID de la respuesta)
- **Request Body**: `DatosActualizarRespuesta`
- **Response**: Datos de la respuesta actualizada.

### Eliminar Respuesta
- **Endpoint**: `/topico/respuesta/{id}`
- **Método HTTP**: `DELETE`
- **Descripción**: Elimina una respuesta existente.
- **Path Variable**: `id` (ID de la respuesta)
- **Response**: No content.

---

## AutenticacionControler

### Autenticar Usuario
- **Endpoint**: `/login`
- **Método HTTP**: `POST`
- **Descripción**: Autentica un usuario y genera un token JWT.
- **Request Body**: `DatosAutenticacionUsuario`
- **Response**: Token JWT.

---

## Agradecimientos

Con esto termina el curso **Formación Java y Spring Boot - ONE** y agradezco la oportunidad de poder crecer y aprender a través de este desafiante y enriquecedor proyecto. Este curso me ha permitido profundizar mis conocimientos en Java y Spring Boot, y me ha dado la confianza para enfrentar futuros desafíos en el desarrollo de aplicaciones backend.

Quiero expresar mi gratitud a todos los instructores, mentores y compañeros de curso que hicieron posible esta experiencia. Su apoyo, orientación y feedback han sido invaluables en mi proceso de aprendizaje.

¡Gracias por esta increíble oportunidad!

---

¡Gracias por tu interés en este proyecto! Si tienes alguna pregunta o sugerencia, no dudes en abrir un issue o contactarme directamente.





