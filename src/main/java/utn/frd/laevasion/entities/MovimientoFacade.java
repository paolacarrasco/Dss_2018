package utn.frd.laevasion.entities;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MovimientoFacade extends AbstractFacade {

    @PersistenceContext(unitName = "utn.frd_LaEvasion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }

    public List<Movimiento> findAllOrdenados(long id) {
        return em.createNamedQuery("Movimiento.findAllOrdenados", Movimiento.class).setParameter("id", id).setMaxResults(10).getResultList();
    }

    public List<Movimiento> findByEstado(int estado) {
        return em.createNamedQuery("Movimiento.findByEstado", Movimiento.class).setParameter("estado", estado).getResultList();
    }

    public Object getSaldo(int idCuenta) {
        return em.createNamedQuery("Movimiento.getSaldo", Movimiento.class).setParameter("idcuenta", idCuenta).getSingleResult();
    }

    public List<Movimiento> findByDescrip(String descripcion) {
        return em.createNamedQuery("Movimiento.findByDescripcion", Movimiento.class).setParameter("descripcion", descripcion).getResultList();
    }
}
