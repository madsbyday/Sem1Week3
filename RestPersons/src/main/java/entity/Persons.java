/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.Size;

/**
 *
 * @author vfgya_000
 */
@Entity
public class Persons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersons;

    private String firstname;

    private String lastname;

    private String phonenr;

    public Persons() {
    }

    public Persons(Integer idpersons) {
        this.idpersons = idpersons;
    }

    public Integer getId() {
        return idpersons;
    }

    public void setIdpersons(Integer idpersons) {
        this.idpersons = idpersons;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(String phonenr) {
        this.phonenr = phonenr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersons != null ? idpersons.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.idpersons == null && other.idpersons != null) || (this.idpersons != null && !this.idpersons.equals(other.idpersons))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Persons[ idpersons=" + idpersons + " ]";
    }
    
}
