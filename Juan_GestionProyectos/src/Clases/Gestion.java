package Clases;

import javax.persistence.*;

@Entity
public class Gestion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "CANTIDAD", nullable = false, precision = 0)
    private Integer cantidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODPROVEEDOR", referencedColumnName = "CODIGO", nullable = false)
    private Proveedores proveedoresByCodproveedor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODPIEZA", referencedColumnName = "CODIGO", nullable = false)
    private Piezas piezasByCodpieza;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CODPROYECTO", referencedColumnName = "CODIGO", nullable = false)
    private Proyectos proyectosByCodproyecto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedores getProveedoresByCodproveedor() {
        return proveedoresByCodproveedor;
    }

    public void setProveedoresByCodproveedor(Proveedores proveedoresByCodproveedor) {
        this.proveedoresByCodproveedor = proveedoresByCodproveedor;
    }

    public Piezas getPiezasByCodpieza() {
        return piezasByCodpieza;
    }

    public void setPiezasByCodpieza(Piezas piezasByCodpieza) {
        this.piezasByCodpieza = piezasByCodpieza;
    }

    public Proyectos getProyectosByCodproyecto() {
        return proyectosByCodproyecto;
    }

    public void setProyectosByCodproyecto(Proyectos proyectosByCodproyecto) {
        this.proyectosByCodproyecto = proyectosByCodproyecto;
    }
    
    public String toString2(){
        StringBuilder text = new StringBuilder();
        text.append("Pieza: "+(this.piezasByCodpieza == null ? " --- ":this.piezasByCodpieza.getCodigo())+", ");
        text.append("Cantidad: "+this.cantidad+", ");
        text.append("Proveedor: "+(this.proveedoresByCodproveedor == null ? " --- ":this.proveedoresByCodproveedor.getCodigo())+", ");
        text.append("Proyecto: "+(this.proyectosByCodproyecto == null ? " --- ":this.proyectosByCodproyecto.getCodigo()));
        return text.toString();
    }
}
