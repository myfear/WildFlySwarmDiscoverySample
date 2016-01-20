package net.eisele.test.swarm.jpa;

/**
 *
 * @author meisele
 */
import io.fabric8.annotations.Path;
import io.fabric8.annotations.Protocol;
import javax.inject.Inject;
import io.fabric8.annotations.ServiceName;

public class MySqlF8Cdi {

    @Inject
    @ServiceName("mysql")
    @Protocol("jdbc:mysql")
    @Path("customer")
    private String urlForCustomerDB;

    public void testCustomerUrl() {
        System.out.println("Bean Name: mysqldb. Type: String. Value:" + urlForCustomerDB);
    }
}
