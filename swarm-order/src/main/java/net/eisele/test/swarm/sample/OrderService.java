package net.eisele.test.swarm.sample;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import net.eisele.test.swarm.jpa.Order;
import net.eisele.test.swarm.jpa.PersistenceHelper;

/**
 * REST Web Service
 *
 * @author myfear
 */
@Path("order")
public class OrderService {

    @Context
    UriInfo context;

    @Inject
    PersistenceHelper helper;

    @GET()
    @Path("all")
    @Produces("application/json")
    public Order[] getAll() {
        return helper.getEntityManager().createNamedQuery("Order.findAll", Order.class).getResultList().toArray(new Order[0]);
    }

    @GET()
    @Path("byId")
    @Produces("application/json")
    public Order[] getbyId(@QueryParam("oid") String oid) {
        return helper.getEntityManager().createNamedQuery("Order.findById", Order.class).setParameter("oId", new Integer(oid)).getResultList().toArray(new Order[0]);
    }
}
