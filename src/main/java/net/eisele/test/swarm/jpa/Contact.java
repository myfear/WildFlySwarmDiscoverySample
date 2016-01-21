/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.test.swarm.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author meisele
 */
@Entity
@Table(name = "CONTACT")
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT e FROM Contact e")
})
@XmlRootElement
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cId;

    @Column(length = 40)
    private String name;

    public Contact() {
    }

    public Integer getCid() {
        return cId;
    }

    public void setCid(Integer id) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact that = (Contact) obj;
        if (that.name.equals(this.name) && that.cId == this.cId) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cId, this.name);
    }

    @Override
    public String toString() {
        return "net.eisele.test.swarm.jpa.Contact[ id=" + cId + " ]";
    }

}
