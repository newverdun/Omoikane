package omoikane.compras.entities;

import omoikane.entities.Usuario;
import omoikane.inventarios.tomaInventario.ItemConteoInventario;
import omoikane.proveedores.Proveedor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Index;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: octavioruizcastillo
 * Date: 23/11/13
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "compra")
public class Compra {

    public enum EstadoPago {
        PAGADA, IMPAGA
    };

    private Long id;

    private Date fecha;

    private Usuario usuario;

    private List<ItemCompra> items;

    private String folioOrigen;

    private Proveedor proveedor;

    private EstadoPago estadoPago = EstadoPago.IMPAGA;

    private Date fechaPago;

    @PrePersist
    public void prePersist() {
        setFecha(new Date());
    }

    @Transactional
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "compra_items")
    @OrderColumn
    public List<ItemCompra> getItems() { return items; }

    public void setItems(List<ItemCompra> items) { this.items = items; }

    private Boolean completado = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra() {
        setCompletado(false);
        items = new ArrayList<>();
    }

    @Column
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Column
    @Index(name = "completadoIndex")
    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    @Column(name = "folio_origen")
    public String getFolioOrigen() {
        return folioOrigen;
    }

    public void setFolioOrigen(String folioOrigen) {
        this.folioOrigen = folioOrigen;
    }

    @Column(name= "estado_pago")
    public EstadoPago getEstadoPago() {
        if(estadoPago==null) estadoPago = EstadoPago.IMPAGA;
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago e) {
        estadoPago = e;
    }

    @Column(name = "fecha_pago")
    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String toString() {
        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
        String proveedor = getProveedor() == null ? "Sin proveedor" : getProveedor().getNombre() ;
        return proveedor+" - "+dateFormat.format(getFecha());
    }
}
