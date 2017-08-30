package omoikane.producto;



import com.fasterxml.jackson.annotation.JsonProperty;
import net.sf.ehcache.hibernate.HibernateUtil;
import omoikane.entities.Anotacion;
import omoikane.entities.CodigoProducto;
import omoikane.entities.Paquete;
import omoikane.inventarios.Stock;
import omoikane.producto.departamento.Departamento;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: octavioruizcastillo
 * Date: 01/10/12
 * Time: 17:54
 * @author octavioruizcastillo
 * Legacy entity. Must be replaced for Producto entity
 */

@Entity
@Table(name = "articulos")

public class Articulo implements Serializable, IProductoApreciado {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_articulo", columnDefinition = "int(11)")
    private Long idArticulo;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "id_linea")
    private Integer idLinea;
    @Column(name = "descripcion")
    private String descripcion;

//    @Column(name = "CLAVE_UNIDAD_SAT_CLAVE")
//    private String claveUnidadSat;
//    @Column(name = "CLAVE_PRODUCTO_SAT_CLAVE")
//    private String claveProductoSat;

    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @Column(name = "uModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uModificacion;
    @Column(name = "version")
    private Integer version;
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private int idGrupo;
    @NotNull
    @Column
    private Boolean activo = true;

    @Column(name = "departamento_id", insertable = false, updatable = false)
    private Long departamentoId;

    @Transient private Boolean esPaqueteDefaultValue = false;

    private Boolean esPaquete = esPaqueteDefaultValue;

    @Transient
    PrecioOmoikaneLogic precio;

    public Articulo() {

    }

    public Articulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Articulo(Long idArticulo, Date uModificacion, int idGrupo) {
        this.idArticulo = idArticulo;
        this.uModificacion = uModificacion;
        this.idGrupo = idGrupo;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Date getUModificacion() {
        return uModificacion;
    }

    public void setUModificacion(Date uModificacion) {
        this.uModificacion = uModificacion;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @PrePersist
    protected void onCreate() {
        uModificacion = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        uModificacion = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_articulo")
    private BaseParaPrecio baseParaPrecio;


    @Override
    public BaseParaPrecio getBaseParaPrecio() {
        return this.baseParaPrecio;
    }

    public String getPreciosAlternosAsString() {
        return this.baseParaPrecio.getPreciosAlternosAsString();
    }

    @OneToMany(mappedBy = "productoContenedor", fetch = FetchType.LAZY)
    public List<Paquete> renglonesPaquete;

    @Transactional
    public List<Paquete> getRenglonesPaquete() {
        List<Paquete> p = renglonesPaquete;
        Hibernate.initialize(p);
        return p;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Departamento departamento;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    //@JoinColumn(name="id_articulo")
    public Stock stock;

    @Transactional
    public Stock getStockInitializated() {
        Stock s = stock;
        Hibernate.initialize(s);
        return s;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock s) {
        this.stock = s;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticulo != null ? idArticulo.hashCode() : 0);
        return hash;
    }

    @Transient
    public PrecioOmoikaneLogic getPrecio() {
        if(precio == null) { precio = new PrecioOmoikaneLogic( getBaseParaPrecio(), getImpuestos() ); }
        return precio;
    }


    @Transient
    public PrecioOmoikaneLogic getPrecio(Integer listaDePrecios_id) {
        precio = new PrecioOmoikaneLogic( listaDePrecios_id, getBaseParaPrecio(), getImpuestos() );
        return precio;
    }


    @Override
    public void setPrecio(IPrecio precio) {
        this.precio = (PrecioOmoikaneLogic) precio;
    }


    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    private Collection<CodigoProducto> codigosAlternos;

    @Transactional
    public Collection<CodigoProducto> getCodigosAlternos() {
        Collection<CodigoProducto> codigosProductos = codigosAlternos;
        Hibernate.initialize(codigosProductos);
        return codigosProductos;
    }

    public void setCodigosAlternos(Collection<CodigoProducto> codigosAlternos) {
        this.codigosAlternos = codigosAlternos;
    }


    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Impuesto> impuestos;

    @Transactional
    public Collection<Impuesto> getImpuestos() {
        Collection<Impuesto> i = impuestos;
        return i;
    }

    public void setImpuestos(Collection<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    @PostUpdate
    public void onPostUpdate() {

        System.out.println("breakpoint");
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idArticulo == null && other.idArticulo != null) || (this.idArticulo != null && !this.idArticulo.equals(other.idArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    public Boolean getEsPaquete() {
        Boolean r = esPaquete != null ? esPaquete : esPaqueteDefaultValue;
        return r;
    }

    public void setEsPaquete(Boolean esGrupo) {
        this.esPaquete = esGrupo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

//    public String getClaveUnidadSat() {
//        return claveUnidadSat;
//    }
//
//    public void setClaveUnidadSat(String claveUnidadSat) {
//        this.claveUnidadSat = claveUnidadSat;
//    }
//
//    public String getClaveProductoSat() {
//        return claveProductoSat;
//    }
//
//    public void setClaveProductoSat(String claveProductoSat) {
//        this.claveProductoSat = claveProductoSat;
//    }
}

