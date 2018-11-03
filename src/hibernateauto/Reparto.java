/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateauto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author biolizard
 */
@Entity
@Table(name = "reparto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparto.findAll", query = "SELECT r FROM Reparto r")
    , @NamedQuery(name = "Reparto.findByCodigo", query = "SELECT r FROM Reparto r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Reparto.findByTipoPapel", query = "SELECT r FROM Reparto r WHERE r.tipoPapel = :tipoPapel")})
public class Reparto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "tipoPapel")
    private String tipoPapel;
    @JoinColumn(name = "C_actor", referencedColumnName = "Codigo")
    @ManyToOne
    private Actores cactor;
    @JoinColumn(name = "C_pelicula", referencedColumnName = "Codigo")
    @ManyToOne
    private Peliculas cpelicula;

    public Reparto() {
    }

    public Reparto(Integer codigo) {
        this.codigo = codigo;
    }

    public Reparto(Integer codigo, String tipoPapel) {
        this.codigo = codigo;
        this.tipoPapel = tipoPapel;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoPapel() {
        return tipoPapel;
    }

    public void setTipoPapel(String tipoPapel) {
        this.tipoPapel = tipoPapel;
    }

    public Actores getCactor() {
        return cactor;
    }

    public void setCactor(Actores cactor) {
        this.cactor = cactor;
    }

    public Peliculas getCpelicula() {
        return cpelicula;
    }

    public void setCpelicula(Peliculas cpelicula) {
        this.cpelicula = cpelicula;
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
        if (!(object instanceof Reparto)) {
            return false;
        }
        Reparto other = (Reparto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernateauto.Reparto[ codigo=" + codigo + " ]";
    }
    
}
