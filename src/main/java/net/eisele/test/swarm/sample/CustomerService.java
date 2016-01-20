package net.eisele.test.swarm.sample;

import io.fabric8.annotations.Protocol;
import io.fabric8.annotations.ServiceName;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author myfear
 */
@Path("customer")
public class CustomerService {

    @Context
    UriInfo context;

    @Inject
    @ServiceName("mysql")
    @Protocol("jdbc:mysql")
    @io.fabric8.annotations.Path("customer")
    private String urlForCustomerDB;

    /**
     * Creates a new instance of CustomerService
     */
    public CustomerService() {
    }

    /**
     * Simple example to output request URI and hostname
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        String text = "WildFly Swarm Docker Application on OpenShift at " + context.getBaseUri() + " - Hostname: " + System.getenv().get("HOSTNAME") + "";
        return "{\"text\":\"" + urlForCustomerDB + "\"}";

    }

}
