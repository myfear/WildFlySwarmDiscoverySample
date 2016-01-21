package net.eisele.test.swarm.sample;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import net.eisele.test.swarm.jpa.Contact;
import net.eisele.test.swarm.jpa.PersistenceHelper;

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
    PersistenceHelper helper;

    @GET
    @Produces("application/json")
    public Contact[] get() {
        return helper.getEntityManager().createNamedQuery("Contact.findAll", Contact.class).getResultList().toArray(new Contact[0]);
    }

}
