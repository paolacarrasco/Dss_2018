package utn.frd.laevasion.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "estado_movimiento")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EstadoMovimiento.findAll", query = "SELECT e FROM EstadoMovimiento e"), @NamedQuery(name = "EstadoMovimiento.findById", query = "SELECT e FROM EstadoMovimiento e WHERE e.id = :id"), @NamedQuery(name = "EstadoMovimiento.findByNombre", query = "SELECT e FROM EstadoMovimiento e WHERE e.nombre = :nombre") })
public class EstadoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;

    public EstadoMovimiento() {
    }

    public EstadoMovimiento(Integer id) {
        this.id = id;
    }

    public EstadoMovimiento(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstadoMovimiento)) {
            return false;
        }
        EstadoMovimiento other = (EstadoMovimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.laevasion.EstadoMovimiento[ id=" + id + " ]";
    }
}
