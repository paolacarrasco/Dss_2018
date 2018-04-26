/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.laevasion.entities;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Paola
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "utn.frd_LaEvasion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }
    
    //Enlisto todos los ultimos diez movimientos
      public List <Movimiento> findAllOrdenados(long id){
        return em.createNamedQuery("Movimiento.findAllOrdenados",Movimiento.class)
                .setParameter("id", id)
                .setMaxResults(10)
                .getResultList();
       }
      public List<Movimiento>findByEstado(int estado){
        return em.createNamedQuery("Movimiento.findByEstado",Movimiento.class)
                .setParameter("estado", estado)
                .getResultList();
    }
      public Object getSaldo(int idCuenta){
        return em.createNamedQuery("Movimiento.getSaldo",Movimiento.class)
                .setParameter("idcuenta", idCuenta)
                .getSingleResult();
      }
      //mlodificar

      
    public List<Movimiento>findByDescrip(String descrip){
        return em.createNamedQuery("Movimiento.findByDescripcion",Movimiento.class)
                .setParameter("descrip", descrip)
                .getResultList();
    }
      //getsingleresult
}

