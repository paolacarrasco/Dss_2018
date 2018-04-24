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
import javax.ws.rs.Path; 
import javax.ejb.EJB; 
import utn.frd.laevasion.entities.ContactoFacade; 
 
@Path("/contacto") 

public class ContactoRest{
    
    @EJB     
    private ContactoFacade ejbContactoFacade;
}