package com.sena.papeleria.dao;

import com.sena.papeleria.config.ConexionBD;
import com.sena.papeleria.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDAO {

    public boolean insertarProducto(Producto producto) {

        String sql = """
                INSERT INTO producto
                (nombre, descripcion, cantidad, precio)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)
        ) {

            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al insertar producto: " + e.getMessage()
            );

            return false;
        }
    }

    public void listarProductos() {

        String sql = "SELECT * FROM producto";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql);
                var resultado = statement.executeQuery()
        ) {

            System.out.println("==============================================");
            System.out.println("           LISTADO DE PRODUCTOS");
            System.out.println("==============================================");

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                int cantidad = resultado.getInt("cantidad");
                double precio = resultado.getDouble("precio");

                System.out.println(
                        "ID: " + id +
                                " | Nombre: " + nombre +
                                " | Descripción: " + descripcion +
                                " | Cantidad: " + cantidad +
                                " | Precio: $" + precio
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al consultar productos: " + e.getMessage()
            );
        }
    }

    public boolean actualizarProducto(Producto producto) {

        String sql = """
            UPDATE producto
            SET nombre = ?,
                descripcion = ?,
                cantidad = ?,
                precio = ?
            WHERE id = ?
            """;

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)
        ) {

            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDescripcion());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());
            statement.setInt(5, producto.getId());

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al actualizar producto: " + e.getMessage()
            );

            return false;
        }
    }

    public boolean eliminarProducto(int id) {

        String sql = "DELETE FROM producto WHERE id = ?";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al eliminar producto: " + e.getMessage()
            );

            return false;
        }
    }
}