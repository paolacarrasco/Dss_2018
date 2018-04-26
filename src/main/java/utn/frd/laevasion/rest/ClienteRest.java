package utn.frd.laevasion.rest;

import javax.ws.rs.Path;
import javax.ejb.EJB;
import utn.frd.laevasion.entities.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.laevasion.entities.Cliente;

@Path("/cliente")
public class ClienteRest {

    @EJB
    private ClienteFacade ejbClienteFacade;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Cliente> findAll() {
        return ejbClienteFacade.findAll();
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON })
    public void create(Cliente cliente) {
        ejbClienteFacade.create(cliente);
    }

    @PUT
    @Consumes({ MediaType.APPLICATION_JSON })
    @Path("/{id}")
    public void edit(@PathParam("id") long id, Cliente cliente) {
        ejbClienteFacade.edit(cliente);
    }

    @DELETE
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    @Path("/{id}")
    public void remove(@PathParam("id") long id) {
        ejbClienteFacade.remove(ejbClienteFacade.find(id));
    }

    @GET
    @Path("/unCliente/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Cliente findById(@PathParam("id") long id) {
        return ejbClienteFacade.find(id);
    }
}
