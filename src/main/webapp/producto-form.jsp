<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>Registrar producto - Papelería SENA</title>

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
                    Registro de productos
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
                Registrar producto
            </h1>

            <p class="form-description">
                Ingresa la información del producto que deseas
                agregar al inventario.
            </p>


            <form
                    action="<%= request.getContextPath() %>/productos"
                    method="post">

                <input
                        type="hidden"
                        name="accion"
                        value="crear">


                <div class="form-group">

                    <label for="nombre">
                        Nombre
                    </label>

                    <input
                            type="text"
                            id="nombre"
                            name="nombre"
                            placeholder="Ej. Marcador negro"
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
                            placeholder="Descripción del producto">

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
                                min="0"
                                placeholder="0"
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
                                min="0"
                                step="0.01"
                                placeholder="0.00"
                                required>

                    </div>

                </div>


                <div class="form-actions">

                    <button
                            type="submit"
                            class="btn">

                        Registrar producto

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