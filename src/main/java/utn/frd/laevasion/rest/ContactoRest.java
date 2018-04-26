package utn.frd.laevasion.rest;

import javax.ws.rs.Path;
import javax.ejb.EJB;
import utn.frd.laevasion.entities.ContactoFacade;

@Path("/contacto")
public class ContactoRest {

    @EJB
    private ContactoFacade ejbContactoFacade;
}
