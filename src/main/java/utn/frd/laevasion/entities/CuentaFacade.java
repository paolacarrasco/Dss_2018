package utn.frd.laevasion.entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CuentaFacade extends AbstractFacade {

    @PersistenceContext(unitName = "utn.frd_LaEvasion_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    public List<Cuenta> findByIdCliente(long id) {
        return em.createNamedQuery("Cuenta.findByIdCliente", Cuenta.class).setParameter("id", id).getResultList();
    }
}
