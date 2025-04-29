import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProductos(Producto producto){
        productos.add(producto);
    }
    public void listarProductos(){
        for (int i = 0; i < productos.size(); i++){
            System.out.println((i + 1) + " " + productos.get(i).mostrarInfo());
        }
    }
    public void bucarProductoPorId(String id){
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId() == id){
                System.out.println(productos.get(i).mostrarInfo());
                break;
            }
        }
    }
    public void eliminarProducto(String id){
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId() == id){
                productos.remove(i);
                break;
            }
        }
    }
    public void actualizarStock(String id, int nuevaCantidad){
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId() == id){
                productos.get(i).setCantidad(nuevaCantidad);
                break;
            }
        }
    }
    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria){
        ArrayList<Producto> listaFiltrada = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getCategoria() == categoria){
                listaFiltrada.add(productos.get(i));
            }
        }
        return listaFiltrada;
    }
    public void obtenerTotalStock(){
        int totalStock = 0;
        for (int i = 0; i < productos.size(); i++){
            totalStock += productos.get(i).getCantidad();
        }
        System.out.println("El stock total de todos los productos es: " + totalStock);
    }
    public Producto obtnerProductoConMayorStock(){
        int indiceProductoMayorStock = 0;
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getCantidad() > productos.get(indiceProductoMayorStock).getCantidad()){
                indiceProductoMayorStock = i;
            }
        }
        return productos.get(indiceProductoMayorStock);
    }
    public void filtrarProductoPorPrecio(double min, double max){
        System.out.println("Este producto se encuentra dentro del rango");
        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getPrecio() > min && productos.get(i).getPrecio() < max){
                System.out.println(productos.get(i).mostrarInfo());
            }
        }
    }
    public void mostrarCategoriasDisponibles(){
        for (CategoriaProducto categoria : CategoriaProducto.values()){
            System.out.println(categoria + " " + categoria.getDescripcion());
        }
    }
}