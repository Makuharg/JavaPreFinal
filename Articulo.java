// plantilla de un artículo
public class Articulo {
    
    // Aplicamos encapsulamiento
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Articulo(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.setNombre(nombre);
        this.setPrecio(precio);
        this.setStock(stock);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }  
    public double getStock() {
        return stock;
    }  
    
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.precio = precio;
    }
    public void setStock(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.stock = stock;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }    

    void mostrar() {
        System.out.println("ID: " + this.id + " | Nombre: " + this.nombre + " | Precio: $" + this.precio + " | Stock: " + this.stock);
    }
}
