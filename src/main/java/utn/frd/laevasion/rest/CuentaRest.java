/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.laevasion.rest;

/**
 *
 * @author Paola
 */
import java.util.List;
import javax.ws.rs.Path; 
import javax.ejb.EJB; 
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import utn.frd.laevasion.entities.Cliente;
import utn.frd.laevasion.entities.CuentaFacade; 
import utn.frd.laevasion.entities.Cuenta; 
import javax.ws.rs.PathParam;

@Path("/cuenta") 

public class CuentaRest{
    
    @EJB     
    private CuentaFacade ejbCuentaFacade;



@GET
@Produces({MediaType.APPLICATION_JSON})
@Path("/{idCliente}")


//Enlista todas las cuentas de un cliente
public List<Cuenta> findByIdCliente(@PathParam("idCliente")long idCliente){
return ejbCuentaFacade.findByIdCliente(idCliente);
    }
}





