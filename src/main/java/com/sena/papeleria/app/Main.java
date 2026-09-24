package com.sena.papeleria.app;

import com.sena.papeleria.dao.ProductoDAO;
import com.sena.papeleria.model.Producto;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductoDAO productoDAO = new ProductoDAO();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        registrarProducto();
                        break;

                    case 2:
                        productoDAO.listarProductos();
                        break;

                    case 3:
                        actualizarProducto();
                        break;

                    case 4:
                        eliminarProducto();
                        break;

                    case 5:
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        System.out.println(
                                "\nOpción no válida. Intente nuevamente."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "\nDebe ingresar un número válido."
                );

                opcion = 0;
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("      SISTEMA DE PAPELERÍA SENA");
        System.out.println("======================================");
        System.out.println("1. Registrar producto");
        System.out.println("2. Consultar productos");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.println("======================================");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarProducto() {

        try {

            System.out.println("\n--- REGISTRAR PRODUCTO ---");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Cantidad: ");
            int cantidad =
                    Integer.parseInt(scanner.nextLine());

            System.out.print("Precio: ");
            double precio =
                    Double.parseDouble(scanner.nextLine());

            Producto producto = new Producto(
                    nombre,
                    descripcion,
                    cantidad,
                    precio
            );

            boolean resultado =
                    productoDAO.insertarProducto(producto);

            if (resultado) {

                System.out.println(
                        "\nProducto registrado correctamente."
                );

            } else {

                System.out.println(
                        "\nNo fue posible registrar el producto."
                );
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nCantidad o precio no válido."
            );
        }
    }

    private static void actualizarProducto() {

        try {

            System.out.println("\n--- ACTUALIZAR PRODUCTO ---");

            productoDAO.listarProductos();

            System.out.print("\nID del producto a actualizar: ");
            int id =
                    Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nueva descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Nueva cantidad: ");
            int cantidad =
                    Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo precio: ");
            double precio =
                    Double.parseDouble(scanner.nextLine());

            Producto producto = new Producto(
                    id,
                    nombre,
                    descripcion,
                    cantidad,
                    precio
            );

            boolean resultado =
                    productoDAO.actualizarProducto(producto);

            if (resultado) {

                System.out.println(
                        "\nProducto actualizado correctamente."
                );

            } else {

                System.out.println(
                        "\nNo se encontró el producto."
                );
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nLos datos numéricos ingresados no son válidos."
            );
        }
    }

    private static void eliminarProducto() {

        try {

            System.out.println("\n--- ELIMINAR PRODUCTO ---");

            productoDAO.listarProductos();

            System.out.print("\nID del producto a eliminar: ");
            int id =
                    Integer.parseInt(scanner.nextLine());

            boolean resultado =
                    productoDAO.eliminarProducto(id);

            if (resultado) {

                System.out.println(
                        "\nProducto eliminado correctamente."
                );

            } else {

                System.out.println(
                        "\nNo se encontró el producto."
                );
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "\nEl ID ingresado no es válido."
            );
        }
    }
}