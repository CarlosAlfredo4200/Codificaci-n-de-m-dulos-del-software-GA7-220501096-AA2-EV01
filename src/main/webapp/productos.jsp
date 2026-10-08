<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sena.papeleria.model.Producto" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Productos - Papelería SENA</title>

    <link rel="stylesheet"
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
                <h2>Sistema de Papelería</h2>

                <p>
                    Administración de productos
                </p>
            </div>

        </div>

    </header>


    <main class="container">

        <section class="card">

            <div class="products-header">

                <div>

                    <span class="page-eyebrow">
                        Inventario
                    </span>

                    <h1>
                        Listado de productos
                    </h1>

                    <p>
                        Consulta, edita y administra los productos
                        registrados en el sistema.
                    </p>

                </div>


                <a class="btn"
                   href="<%= request.getContextPath() %>/producto-form.jsp">

                    + Registrar producto

                </a>

            </div>


            <div class="products-toolbar">

                <a class="back-link"
                   href="<%= request.getContextPath() %>/">

                    ← Volver al inicio

                </a>

            </div>


            <div class="table-container">

                <table class="products-table">

                    <thead>

                    <tr>

                        <th>ID</th>

                        <th>Nombre</th>

                        <th>Descripción</th>

                        <th>Cantidad</th>

                        <th>Precio</th>

                        <th>Acciones</th>

                    </tr>

                    </thead>


                    <tbody>

                    <%
                        List<Producto> productos =
                                (List<Producto>) request.getAttribute("productos");

                        if (productos != null && !productos.isEmpty()) {

                            for (Producto producto : productos) {
                    %>


                    <tr>

                        <td>
                            <%= producto.getId() %>
                        </td>

                        <td>
                            <%= producto.getNombre() %>
                        </td>

                        <td>
                            <%= producto.getDescripcion() %>
                        </td>

                        <td>
                            <%= producto.getCantidad() %>
                        </td>

                        <td>
                            $<%= producto.getPrecio() %>
                        </td>


                        <td class="table-actions">

                            <a
                                    class="btn btn-secondary btn-small"
                                    href="<%= request.getContextPath() %>/productos?accion=editar&id=<%= producto.getId() %>">

                                Editar

                            </a>


                            <form
                                    class="inline-form"
                                    action="<%= request.getContextPath() %>/productos"
                                    method="post">

                                <input
                                        type="hidden"
                                        name="accion"
                                        value="eliminar"
                                >

                                <input
                                        type="hidden"
                                        name="id"
                                        value="<%= producto.getId() %>"
                                >


                                <button
                                        class="btn btn-danger btn-small"
                                        type="submit"
                                        onclick="return confirm('¿Desea eliminar este producto?');">

                                    Eliminar

                                </button>

                            </form>

                        </td>

                    </tr>


                    <%
                            }

                        } else {
                    %>


                    <tr>

                        <td
                                colspan="6"
                                class="empty-state">

                            No hay productos registrados.

                        </td>

                    </tr>


                    <%
                        }
                    %>

                    </tbody>

                </table>

            </div>

        </section>

    </main>

</div>

</body>

</html>