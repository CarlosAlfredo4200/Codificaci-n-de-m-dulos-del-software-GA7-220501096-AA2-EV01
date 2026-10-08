package com.sena.papeleria.servlet;

import com.sena.papeleria.dao.ProductoDAO;
import com.sena.papeleria.model.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    private final ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("editar".equals(accion)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            Producto producto =
                    productoDAO.obtenerProductoPorId(id);

            request.setAttribute(
                    "producto",
                    producto
            );

            request
                    .getRequestDispatcher("/producto-editar.jsp")
                    .forward(request, response);

            return;
        }

        List<Producto> productos =
                productoDAO.obtenerProductos();

        request.setAttribute(
                "productos",
                productos
        );

        request
                .getRequestDispatcher("/productos.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        request.setCharacterEncoding("UTF-8");

        String accion =
                request.getParameter("accion");

        if ("actualizar".equals(accion)) {

            actualizarProducto(request);

        } else if ("eliminar".equals(accion)) {

            eliminarProducto(request);

        } else {

            registrarProducto(request);
        }

        response.sendRedirect(
                request.getContextPath() + "/productos"
        );
    }

    private void registrarProducto(
            HttpServletRequest request
    ) {

        String nombre =
                request.getParameter("nombre");

        String descripcion =
                request.getParameter("descripcion");

        int cantidad =
                Integer.parseInt(
                        request.getParameter("cantidad")
                );

        double precio =
                Double.parseDouble(
                        request.getParameter("precio")
                );

        Producto producto = new Producto(
                nombre,
                descripcion,
                cantidad,
                precio
        );

        productoDAO.insertarProducto(producto);
    }

    private void actualizarProducto(
            HttpServletRequest request
    ) {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        String nombre =
                request.getParameter("nombre");

        String descripcion =
                request.getParameter("descripcion");

        int cantidad =
                Integer.parseInt(
                        request.getParameter("cantidad")
                );

        double precio =
                Double.parseDouble(
                        request.getParameter("precio")
                );

        Producto producto = new Producto(
                id,
                nombre,
                descripcion,
                cantidad,
                precio
        );

        productoDAO.actualizarProducto(producto);
    }

    private void eliminarProducto(
            HttpServletRequest request
    ) {

        int id =
                Integer.parseInt(
                        request.getParameter("id")
                );

        productoDAO.eliminarProducto(id);
    }
}