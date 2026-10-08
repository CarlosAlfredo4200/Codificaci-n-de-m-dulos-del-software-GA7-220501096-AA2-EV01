# Sistema de Papelería SENA

Proyecto desarrollado como parte de las evidencias:

- GA7-220501096-AA2-EV01 - Codificación de módulos del software.
- GA7-220501096-AA2-EV02 - Módulos de software codificados y probados.

## Descripción

El proyecto implementa un módulo para la gestión de productos de papelería.

La aplicación fue desarrollada inicialmente como un módulo stand-alone utilizando Java, JDBC y SQL Server. Posteriormente fue ampliada a una aplicación web mediante Servlets, JSP y Apache Tomcat.

El sistema permite realizar las operaciones fundamentales de un CRUD:

- Registrar productos.
- Consultar productos.
- Actualizar productos.
- Eliminar productos.

## Tecnologías utilizadas

- Java 21
- Maven
- JDBC
- Microsoft SQL Server
- Microsoft JDBC Driver for SQL Server
- Jakarta Servlet API
- JSP
- HTML
- CSS
- Apache Tomcat 10.1
- Git
- GitHub
- IntelliJ IDEA

## Arquitectura

El proyecto está organizado separando las diferentes responsabilidades del sistema.

```text
com.sena.papeleria
│
├── app
│   └── Main.java
│
├── config
│   └── ConexionBD.java
│
├── dao
│   └── ProductoDAO.java
│
├── model
│   └── Producto.java
│
└── servlet
    └── ProductoServlet.java
```

La aplicación web utiliza además:

```text
src/main/webapp
│
├── css
│   └── styles.css
│
├── index.jsp
├── productos.jsp
├── producto-form.jsp
├── producto-editar.jsp
│
└── WEB-INF
```

## Funcionamiento general

La arquitectura web funciona de la siguiente manera:

```text
Navegador
    ↓
JSP / HTML
    ↓
ProductoServlet
    ↓
ProductoDAO
    ↓
JDBC
    ↓
SQL Server
```

## Conexión JDBC

La clase:

```text
ConexionBD.java
```

es responsable de establecer la conexión entre Java y Microsoft SQL Server mediante JDBC.

La contraseña de la base de datos no se almacena directamente en el código fuente. Se utiliza la variable de entorno:

```text
PAPELERIA_DB_PASSWORD
```

## Operaciones CRUD

### Crear

Permite registrar nuevos productos.

```text
INSERT INTO producto
```

### Consultar

Permite consultar los productos almacenados.

```text
SELECT * FROM producto
```

### Actualizar

Permite modificar la información de un producto existente.

```text
UPDATE producto
```

### Eliminar

Permite eliminar un producto mediante su identificador.

```text
DELETE FROM producto
```

## Aplicación stand-alone

La evidencia EV01 incluye una aplicación ejecutada desde:

```text
Main.java
```

mediante un menú por consola.

Desde este módulo se pueden realizar las operaciones CRUD utilizando JDBC.

## Aplicación web

La evidencia EV02 amplía el proyecto mediante una aplicación web.

Se utiliza:

- JSP para las vistas.
- Servlets para procesar solicitudes.
- JDBC para acceder a la base de datos.
- SQL Server como sistema gestor de base de datos.
- Apache Tomcat como servidor de aplicaciones.

## Métodos HTTP

El Servlet utiliza los métodos HTTP:

### GET

Se utiliza para consultar información y cargar vistas.

Ejemplo:

```text
GET /productos
```

### POST

Se utiliza para enviar datos desde los formularios.

Ejemplos:

```text
Registrar producto
Actualizar producto
Eliminar producto
```

## JSP

Las páginas JSP utilizadas son:

```text
index.jsp
productos.jsp
producto-form.jsp
producto-editar.jsp
```

Estas páginas permiten visualizar y administrar la información mediante una interfaz web responsive.

## Base de datos

Base de datos:

```text
papeleria_sena
```

Tabla principal:

```text
producto
```

Campos:

```text
id
nombre
descripcion
cantidad
precio
```

## Ejecución del proyecto

### Requisitos

Es necesario tener instalado:

- Java 21
- Microsoft SQL Server
- Apache Tomcat 10.1
- Maven
- IntelliJ IDEA

### Configuración de la base de datos

Ejecutar el script:

```text
database/papeleria_sena.sql
```

### Variable de entorno

Configurar:

```text
PAPELERIA_DB_PASSWORD
```

con la contraseña correspondiente al usuario de SQL Server.

### Ejecutar aplicación web

Desplegar el artifact:

```text
papeleria-jdbc:war exploded
```

en Apache Tomcat.

La aplicación quedará disponible en:

```text
http://localhost:8080/papeleria/
```

## Estándares de codificación

Se utilizaron las siguientes convenciones:

### Clases

PascalCase:

```text
Producto
ProductoDAO
ProductoServlet
ConexionBD
```

### Métodos y variables

camelCase:

```text
insertarProducto()
obtenerProductos()
actualizarProducto()
eliminarProducto()
obtenerProductoPorId()
```

### Paquetes

Los paquetes utilizan nombres en minúscula:

```text
com.sena.papeleria.app
com.sena.papeleria.config
com.sena.papeleria.dao
com.sena.papeleria.model
com.sena.papeleria.servlet
```

## Versionamiento

El proyecto utiliza Git y GitHub para el control de versiones.

Durante el desarrollo se registraron los diferentes avances mediante commits.

## Evidencias cumplidas

### GA7-220501096-AA2-EV01

- Conexión a base de datos utilizando JDBC.
- Implementación de CRUD.
- Uso de Git y GitHub.
- Aplicación de estándares de codificación.

### GA7-220501096-AA2-EV02

- Formularios HTML/JSP conectados con Servlets.
- Uso de métodos GET y POST.
- Implementación de elementos JSP.
- Uso de herramientas de versionamiento.
- CRUD web conectado a SQL Server.

## Autor

Carlos Alfredo Montoya Goez

SENA - ANALISIS Y DESARROLLO DE SOFTWARE. (3336098)
