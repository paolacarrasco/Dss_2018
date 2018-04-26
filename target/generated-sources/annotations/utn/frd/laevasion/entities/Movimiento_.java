package utn.frd.laevasion.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-25T17:03:17")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Integer> tipo;
    public static volatile SingularAttribute<Movimiento, Integer> estado;
    public static volatile SingularAttribute<Movimiento, Date> creado;
    public static volatile SingularAttribute<Movimiento, String> descrip;
    public static volatile SingularAttribute<Movimiento, Date> procesado;
    public static volatile SingularAttribute<Movimiento, Integer> id;
    public static volatile SingularAttribute<Movimiento, Integer> idCuenta;
    public static volatile SingularAttribute<Movimiento, Double> importe;

}