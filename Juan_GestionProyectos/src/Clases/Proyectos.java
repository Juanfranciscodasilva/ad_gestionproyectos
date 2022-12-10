package Clases;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Proyectos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODIGO", nullable = false, length = 6)
    private String codigo;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;
    @Basic
    @Column(name = "CIUDAD", nullable = true, length = 40)
    private String ciudad;
    @OneToMany(mappedBy = "proyectosByCodproyecto")
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Collection<Gestion> getGestionsByCodigo() {
        return gestionsByCodigo;
    }

    public void setGestionsByCodigo(Collection<Gestion> gestionsByCodigo) {
        this.gestionsByCodigo = gestionsByCodigo;
    }
}
