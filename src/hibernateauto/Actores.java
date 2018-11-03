/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateauto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author biolizard
 */
@Entity
@Table(name = "actores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actores.findAll", query = "SELECT a FROM Actores a")
    , @NamedQuery(name = "Actores.findByCodigo", query = "SELECT a FROM Actores a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Actores.findByNombre", query = "SELECT a FROM Actores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Actores.findByFnacimiento", query = "SELECT a FROM Actores a WHERE a.fnacimiento = :fnacimiento")
    , @NamedQuery(name = "Actores.findByNacionalidad", query = "SELECT a FROM Actores a WHERE a.nacionalidad = :nacionalidad")})
public class Actores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "F_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fnacimiento;
    @Basic(optional = false)
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    @OneToMany(mappedBy = "cactor")
    private Collection<Reparto> repartoCollection;

    public Actores() {
    }

    public Actores(Integer codigo) {
        this.codigo = codigo;
    }

    public Actores(Integer codigo, String nombre, Date fnacimiento, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fnacimiento = fnacimiento;
        this.nacionalidad = nacionalidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public Collection<Reparto> getRepartoCollection() {
        return repartoCollection;
    }

    public void setRepartoCollection(Collection<Reparto> repartoCollection) {
        this.repartoCollection = repartoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actores)) {
            return false;
        }
        Actores other = (Actores) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateauto.Actores[ codigo=" + codigo + " ]";
    }
    
}
