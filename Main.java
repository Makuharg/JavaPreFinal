
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Articulo> lista = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void crearArticulo() {
        // Validando ID para que no este repetido
        int id;
        boolean idRepetido;

        do{
            idRepetido = false;
            System.out.println("Ingrese el ID del articulo: ");
            id = sc.nextInt();
            sc.nextLine(); // limpiamos buffer

            // verificamos si el ID ya existe
            for(Articulo a : lista) {
                if (a.getId() == id){
                    System.out.println("El ID ingresado ya existe. Por favor ingrese un ID diferente.");
                    idRepetido = true;
                    break;
                }
            }
        } while (idRepetido);

        // Validación del nombre
        String nombre;
        do {
            System.out.print("Ingrese el nombre del artículo: ");
            nombre = sc.nextLine();
            if(nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while(nombre.isEmpty()); 
        
        // Validacion del precio
        double precio;
        do {
            System.out.print("Ingrese el precio del articulo: ");
            precio = sc.nextDouble();
            sc.nextLine(); // Limpiar buffer
            if(precio <= 0) {
                System.out.println("El precio debe ser mayor que 0.");
            }
        } while (precio <= 0);

        // Validacion del stock
        int stock;
        do {
            System.out.print("Ingrese el stock del articulo: ");
            stock = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            if(stock <= 0) {
                System.out.println("El stock debe ser mayor que 0.");
            }
        } while (stock <= 0);

        // Crear y agregar el nuevo artículo
        Articulo nuevoArticulo = new Articulo(id, nombre, precio, stock);
        lista.add(nuevoArticulo);
        System.out.println("Artículo agregado correctamente.");
    }

    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            System.out.println( "\nLista de articulos: ");
            for (Articulo articulo : lista) {               
                articulo.mostrar();
            }
        }
    }

    public static void modificarArticulo() {
        System.out.print("ID del artículo a modificar: ");
        int id = sc.nextInt();
        for (Articulo a : lista) {
            if (a.getId() == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre del articulo: ");
                a.setNombre(sc.nextLine());
                System.out.print("Nuevo precio del articulo: ");
                a.setPrecio(sc.nextDouble());
                System.out.print("Nuevo stock del articulo: ");
                a.setStock(sc.nextInt());
                System.out.println("Artículo actualizado.");
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    public static void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int idAEliminar = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        boolean encontrado = false;

        // validacion por si el ID del articulo a eliminar no existe
        Iterator<Articulo> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Articulo a = iterator.next();
            if (a.getId() == idAEliminar) {
                iterator.remove();
                System.out.println("Artículo eliminado con éxito.");
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("El artículo con ID " + idAEliminar + " no existe.");
        }
    }
}
