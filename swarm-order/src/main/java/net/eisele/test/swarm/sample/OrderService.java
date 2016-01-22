package net.eisele.test.swarm.sample;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import net.eisele.test.swarm.jpa.Orders;
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
    public Orders[] getAll() {
        return helper.getEntityManager().createNamedQuery("Orders.findAll", Orders.class).getResultList().toArray(new Orders[0]);
    }

    @GET()
    @Path("byId")
    @Produces("application/json")
    public Orders[] getbyId(@QueryParam("oid") String oid) {
        return helper.getEntityManager().createNamedQuery("Orders.findById", Orders.class).setParameter("oId", new Integer(oid)).getResultList().toArray(new Orders[0]);
    }
}
