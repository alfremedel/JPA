# PracticaJPA - Sistema de Gestión de Personas con JPA y Swing

Proyecto académico desarrollado en Java utilizando **JPA (Java Persistence API)** y **Hibernate** como proveedor de persistencia para interactuar con una base de datos **MySQL**, incorporando una interfaz gráfica con **Java Swing**.

---

## 🚀 Características

* **Persistencia con JPA**: Mapeo objeto-relacional (ORM) con anotaciones `@Entity` y `@Table` para la gestión de datos.
* **Patrón DAO (Data Access Object)**: Separación clara de la lógica de acceso a datos mediante `PersonaDao` y `PersonaDaoImpl`.
* **Interfaz Gráfica Swing**: Módulo visual interactivo (`VentanaPersonal`) para listar y visualizar en tiempo real los datos registrados en la base de datos.
* **Arquitectura Modular**: Organización por paquetes (`dao`, `entidades`, `main`).

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje**: Java (JDK 8+)
* **IDE**: NetBeans IDE
* **ORM**: JPA / Hibernate
* **Base de Datos**: MySQL (`bd_practica`)
* **GUI**: Java Swing (`JFrame`, `JTable`)

---

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/alfremedel/jpa)

## 🗄️ Estructura de la Base de Datos

La aplicación interactúa con la base de datos `bd_practica` y la tabla `persona`:

```sql
CREATE DATABASE IF NOT EXISTS bd_practica;
USE bd_practica;

CREATE TABLE IF NOT EXISTS persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL
);
PracticaJPA/
 ├── src/
 │    ├── META-INF/
 │    │    └── persistence.xml         # Configuración de JPA y la unidad de persistencia PracticaPU
 │    └── practicajpa/
 │         ├── VentanaPersonal.java    # Interfaz gráfica principal Swing
 │         ├── dao/
 │         │    ├── PersonaDao.java     # Interfaz DAO
 │         │    └── PersonaDaoImpl.java # Implementación DAO con EntityManager
 │         ├── entidades/
 │         │    └── Persona.java        # Entidad JPA
 │         └── main/
 └── README.md
