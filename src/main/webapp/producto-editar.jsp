<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sena.papeleria.model.Producto" %>

<%
    Producto producto =
            (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Editar producto - Papelería SENA</title>

    <link
            rel="stylesheet"
            href="<%= request.getContextPath() %>/css/styles.css">

</head>

<body>

<div class="page-shell">

    <header class="topbar">

        <div class="topbar__brand">

            <span class="topbar__badge">
                SENA
            </span>

            <div>

                <h2>
                    Sistema de Papelería
                </h2>

                <p>
                    Actualización de productos
                </p>

            </div>

        </div>

    </header>


    <main class="container">

        <div class="form-card">

            <span class="page-eyebrow">
                Inventario
            </span>

            <h1>
                Editar producto
            </h1>

            <p class="form-description">
                Modifica la información del producto seleccionado
                y guarda los cambios realizados.
            </p>


            <form
                    action="<%= request.getContextPath() %>/productos"
                    method="post">

                <input
                        type="hidden"
                        name="accion"
                        value="actualizar">

                <input
                        type="hidden"
                        name="id"
                        value="<%= producto.getId() %>">


                <div class="form-group">

                    <label for="nombre">
                        Nombre
                    </label>

                    <input
                            type="text"
                            id="nombre"
                            name="nombre"
                            value="<%= producto.getNombre() %>"
                            required>

                </div>


                <div class="form-group">

                    <label for="descripcion">
                        Descripción
                    </label>

                    <input
                            type="text"
                            id="descripcion"
                            name="descripcion"
                            value="<%= producto.getDescripcion() %>">

                </div>


                <div class="form-row">

                    <div class="form-group">

                        <label for="cantidad">
                            Cantidad
                        </label>

                        <input
                                type="number"
                                id="cantidad"
                                name="cantidad"
                                value="<%= producto.getCantidad() %>"
                                min="0"
                                required>

                    </div>


                    <div class="form-group">

                        <label for="precio">
                            Precio
                        </label>

                        <input
                                type="number"
                                id="precio"
                                name="precio"
                                value="<%= producto.getPrecio() %>"
                                min="0"
                                step="0.01"
                                required>

                    </div>

                </div>


                <div class="form-actions">

                    <button
                            type="submit"
                            class="btn">

                        Guardar cambios

                    </button>


                    <a
                            class="btn btn-secondary"
                            href="<%= request.getContextPath() %>/productos">

                        Cancelar

                    </a>

                </div>

            </form>

        </div>

    </main>

</div>

</body>

</html>