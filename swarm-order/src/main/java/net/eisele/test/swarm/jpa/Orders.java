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
@Table(name = "ORDERS")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.oId = :oId")
})
@XmlRootElement
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer oId;

    @Column(length = 40)
    private String name;

    public Orders() {
    }

    public Integer getOid() {
        return oId;
    }

    public void setOid(Integer id) {
        this.oId = id;
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
        if (!(obj instanceof Orders)) {
            return false;
        }
        Orders that = (Orders) obj;
        if (that.name.equals(this.name) && Objects.equals(that.oId, this.oId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.oId, this.name);
    }

    @Override
    public String toString() {
        return "net.eisele.test.swarm.jpa.Order[ id=" + oId + " ]";
    }

}
