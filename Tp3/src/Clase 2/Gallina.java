class Gallina {
    private int idGallina;
    private int edad;
    private int huevosPuestos;

    public Gallina(int idGallina) {
        this.idGallina = idGallina;
        this.edad = 0;
        this.huevosPuestos = 0;
    }

    public void ponerHuevo() {
        huevosPuestos++;
    }

    public void envejecer() {
        edad++;
    }

    public String mostrarEstado() {
        return "ID Gallina: " + idGallina + ", Edad: " + edad + " años, Huevos Puestos: " + huevosPuestos;
    }


}

