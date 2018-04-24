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
import utn.frd.laevasion.entities.MovimientoFacade;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utn.frd.laevasion.entities.Cliente;
import utn.frd.laevasion.entities.Movimiento;

 
@Path("/movimiento") 

public class MovimientoRest{
    
    @EJB     
    private MovimientoFacade ejbMovimientoFacade;


@GET

@Produces({MediaType.APPLICATION_JSON})
public List<Movimiento>findAllOrdenados(){
return ejbMovimientoFacade.findAllOrdenados();
}


@POST
@Consumes({MediaType.APPLICATION_JSON})

public void create(Movimiento movimiento){
ejbMovimientoFacade.create(movimiento);
}


//actualizar movimiento 
@PUT
@Consumes({MediaType.APPLICATION_JSON})
@Path("/{id}")



public void edit(@PathParam("id")long id, Movimiento movimiento){
ejbMovimientoFacade.edit(movimiento);
}

@GET
@Path ("/{descrip}")
@Produces({MediaType.APPLICATION_JSON})

public List<Movimiento> findByDescripcion(@PathParam("descrip")String descrip){
return ejbMovimientoFacade.findByDescrip(descrip);
}





//Enlistar los movimientos pasando como parametro el id del estado determinado
public List<Movimiento> findByEstado(@PathParam("estado")int estado){
return ejbMovimientoFacade.findByEstado(estado);
    }

}


