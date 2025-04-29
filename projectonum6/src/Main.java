import java.security.ProtectionDomain;
public class Main {
    public static void main(String[]args){

        Inventario inventario = new Inventario();

        Producto p1 = new Producto("HP123", "Laptop HP", 2000000.0, 20, CategoriaProducto.ELECTRONICA);
        Producto p2 = new Producto("DG123", "Cartera DG", 120000.0, 10, CategoriaProducto.ROPA);
        Producto p3 = new Producto("L123", "Papas Fritas Lays", 10000.0, 25, CategoriaProducto.ALIMENTOS);
        Producto p4 = new Producto("C123", "Colchon Canon 2p", 170000.0, 3, CategoriaProducto.HOGAR);

        inventario.agregarProductos(p1);
        inventario.agregarProductos(p2);
        inventario.agregarProductos(p3);
        inventario.agregarProductos(p4);
        inventario.listarProductos();
        inventario.obtenerTotalStock();
        inventario.obtnerProductoConMayorStock();
        inventario.filtrarProductoPorPrecio(100000.0, 180000.0);
        inventario.mostrarCategoriasDisponibles();
        inventario.bucarProductoPorId("C123");
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        inventario.eliminarProducto("HP123");
        inventario.listarProductos();
    }
}