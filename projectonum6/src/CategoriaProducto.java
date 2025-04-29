public enum CategoriaProducto {
    ALIMENTOS("Productos comestibles"),
    ELECTRONICA("Productos electrónicos"),
    ROPA("Prendas de vestir"),
    HOGAR("Articulos para el hogar");

    private final String descripcion;

    CategoriaProducto(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }


}