package Clases;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Proveedores {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODIGO", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;
    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 30)
    private String apellidos;
    @Basic
    @Column(name = "DIRECCION", nullable = false, length = 40)
    private String direccion;
    @OneToMany(mappedBy = "proveedoresByCodproveedor")
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Collection<Gestion> getGestionsByCodigo() {
        return gestionsByCodigo;
    }

    public void setGestionsByCodigo(Collection<Gestion> gestionsByCodigo) {
        this.gestionsByCodigo = gestionsByCodigo;
    }

    @Override
    public String toString() {
        return "Proveedores{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
