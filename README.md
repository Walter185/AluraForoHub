
# 🧵 ForoHub - API REST

Este proyecto es una API REST para la gestión de tópicos en un foro de discusión de tecnología. Está construido con **Spring Boot 3**, utiliza **Flyway** para la gestión de migraciones y **JWT** para autenticación.

---

## 📚 Funcionalidades Principales

- Registro y login de usuarios (con JWT)
- CRUD de tópicos
- Asociación de tópicos a cursos y autores
- Persistencia con JPA + H2/PostgreSQL
- Migraciones con Flyway

---

## 🧪 Endpoints

### 🔐 Autenticación

| Método | Endpoint       | Descripción                |
|--------|----------------|----------------------------|
| POST   | `/api/auth/login` | Login de usuario (JWT)     |
| POST   | `/api/auth/register` | Registro de usuario        |

### 📌 Tópicos

| Método | Endpoint       | Descripción                |
|--------|----------------|----------------------------|
| POST   | `/api/topicos` | Crear un nuevo tópico      |
| GET    | `/api/topicos` | Listar todos los tópicos   |

### 📘 Cursos

| Método | Endpoint       | Descripción                |
|--------|----------------|----------------------------|
| GET    | `/api/cursos`  | Listar cursos disponibles  |

---

## 🧱 Estructura del Proyecto

```
src/
├── auth/           # Seguridad y JWT
├── topico/         # Lógica de tópicos
├── curso/          # Cursos relacionados
├── usuario/        # Registro y login
└── config/         # Configuración general (Security, etc.)
```

---

## 🧰 Tecnologías Usadas

- Java 21
- Spring Boot 3.5
- Spring Security + JWT
- Maven
- Flyway
- Lombok
- PostgreSQL / H2 (para test)
- JPA / Hibernate

---

## 🚀 Cómo ejecutar

1. Clona el proyecto:
```bash
git clone https://github.com/walter185/forohub.git
cd forohub
```

2. Configura la base de datos en `application.properties`

3. Ejecuta el proyecto:
```bash
mvn spring-boot:run
```

---

## ✍️ Autor

**Walter Liendo**  
Estudiante Alura Latam - Backend

---

© 2025 - Proyecto educativo para el Challenge de Alura LATAM.
