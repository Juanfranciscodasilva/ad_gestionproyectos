package Clases;

public class EstadisticasPiezas {
    
    private String codigo;

    private String nombre;

    private int precio;

    private String descripcion;
    
    private int numeroPiezas;
    
    private int numeroGestiones;
    
    private int numeroProyectos;
    
    private int numeroProveedores;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroGestiones() {
        return numeroGestiones;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    public void setNumeroGestiones(int numeroGestiones) {
        this.numeroGestiones = numeroGestiones;
    }

    public int getNumeroProyectos() {
        return numeroProyectos;
    }

    public void setNumeroProyectos(int numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }

    public int getNumeroProveedores() {
        return numeroProveedores;
    }

    public void setNumeroProveedores(int numeroProveedores) {
        this.numeroProveedores = numeroProveedores;
    }
    
    
}
