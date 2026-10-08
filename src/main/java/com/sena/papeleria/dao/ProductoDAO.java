package com.sena.papeleria.dao;

import com.sena.papeleria.config.ConexionBD;
import com.sena.papeleria.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

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

        String sql = "SELECT * FROM producto ORDER BY id";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()
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

    public List<Producto> obtenerProductos() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM producto ORDER BY id";

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql);
                ResultSet resultado = statement.executeQuery()
        ) {

            while (resultado.next()) {

                Producto producto = new Producto(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("descripcion"),
                        resultado.getInt("cantidad"),
                        resultado.getDouble("precio")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {

            System.err.println(
                    "Error al obtener productos: " + e.getMessage()
            );
        }

        return productos;
    }

    public Producto obtenerProductoPorId(int id) {

        String sql = """
            SELECT id, nombre, descripcion, cantidad, precio
            FROM producto
            WHERE id = ?
            """;

        try (
                Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement statement = conexion.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            try (ResultSet resultado = statement.executeQuery()) {

                if (resultado.next()) {

                    return new Producto(
                            resultado.getInt("id"),
                            resultado.getString("nombre"),
                            resultado.getString("descripcion"),
                            resultado.getInt("cantidad"),
                            resultado.getDouble("precio")
                    );
                }
            }

        } catch (SQLException e) {

            System.err.println(
                    "Error al obtener producto por ID: " + e.getMessage()
            );

            e.printStackTrace();
        }

        return null;
    }
}