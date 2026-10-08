<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Papelería SENA</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>

<div class="page-shell">

    <header class="topbar">
        <div class="topbar__brand">
            <span class="topbar__badge">SENA</span>
            <div>
                <h2>Sistema de Papelería</h2>
                <p>Módulo académico con JDBC, JSP y Servlets</p>
            </div>
        </div>
    </header>

    <main class="container">

        <section class="hero-card">
            <div class="hero-card__content">
                <span class="hero-card__tag">Proyecto formativo GA7 - AA2</span>

                <h1>Sistema de Papelería SENA</h1>

                <p class="hero-card__text">
                    Aplicación web desarrollada para la gestión de productos de papelería,
                    integrando Java, JSP, Servlets, JDBC y SQL Server para realizar operaciones
                    de registro, consulta, actualización y eliminación de información.
                </p>

                <div class="hero-card__actions">
                    <a class="btn" href="<%= request.getContextPath() %>/productos">
                        Ver productos
                    </a>

                    <a class="btn btn-secondary" href="<%= request.getContextPath() %>/producto-form.jsp">
                        Registrar producto
                    </a>
                </div>
            </div>

            <div class="hero-card__panel">
                <div class="info-box">
                    <h3>Objetivo del sistema</h3>
                    <p>
                        Facilitar la administración de los productos de papelería mediante
                        un CRUD funcional, con conexión a base de datos y despliegue web.
                    </p>
                </div>
            </div>
        </section>

        <section class="section-grid">

            <article class="card">
                <h3>Tecnologías utilizadas</h3>

                <ul class="feature-list">
                    <li>Java</li>
                    <li>JSP</li>
                    <li>Servlets</li>
                    <li>JDBC</li>
                    <li>SQL Server</li>
                    <li>Apache Tomcat</li>
                    <li>Maven</li>
                    <li>Git y GitHub</li>
                </ul>
            </article>

            <article class="card">
                <h3>Funcionalidades principales</h3>

                <ul class="feature-list">
                    <li>Registro de productos</li>
                    <li>Consulta del listado</li>
                    <li>Edición de información</li>
                    <li>Eliminación de registros</li>
                    <li>Interfaz web responsive</li>
                    <li>Conexión a SQL Server con JDBC</li>
                </ul>
            </article>

        </section>

        <section class="card highlight-card">
            <h3>Descripción general</h3>
            <p>
                Este sistema corresponde al desarrollo de un módulo de software orientado
                a la administración de productos de papelería, aplicando buenas prácticas
                de codificación, conexión a bases de datos y uso de tecnologías web vistas
                en el componente formativo.
            </p>
        </section>

    </main>

</div>

</body>
</html>