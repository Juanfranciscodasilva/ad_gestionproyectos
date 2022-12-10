package Clases;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Piezas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODIGO", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "PRECIO", nullable = false, precision = 0)
    private int precio;
    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 200)
    private String descripcion;
    @OneToMany(mappedBy = "piezasByCodpieza")
    private Collection<Gestion> gestionsByCodigo;

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

    public Collection<Gestion> getGestionsByCodigo() {
        return gestionsByCodigo;
    }

    public void setGestionsByCodigo(Collection<Gestion> gestionsByCodigo) {
        this.gestionsByCodigo = gestionsByCodigo;
    }
}
