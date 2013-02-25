package hibernate.relaciones.unouno;

import hibernate.relaciones.unouno.modelo.Pais;
import hibernate.relaciones.unouno.modelo.Presidente;
import org.hibernate.Session;
public class Main2
{
    public static void main(String[] args)
    {
        Pais pais1 = new Pais();
        pais1.setNombre("China");

        Pais pais2 = new Pais();
        pais2.setNombre("Corea");


        Presidente presidente1 = new Presidente();
        presidente1.setNombre("Jiang Zemin");

        Presidente presidente2 = new Presidente();
        presidente2.setNombre("Kim Dae-Jung");
        /* en este caso debemos los dos objetos de los dos lados de la relaci�n
         * es decir, debemos agregar el Presidente al Pais y el Pais al Presidente
         */
        pais1.setPresidente(presidente1);
        pais2.setPresidente(presidente2);

        presidente1.setPais(pais1);
        presidente2.setPais(pais2);

        Session sesion = HibernateUtil.getSessionFactory().openSession();


        /*Este pais se agrega para comprobar que los presidentes tomen el mismo
        identificador que los paises*/
        Pais p = new Pais();
        p.setNombre("Chipre");


        /*En la primer sesion a la base de datos almacenamos los dos objetos Pais
        los objetos Presidente se almacenaran en cascada*/
        sesion.beginTransaction();

        sesion.persist(p);
        sesion.persist(pais1);
        sesion.persist(pais2);

        sesion.getTransaction().commit();
        sesion.close();


        /*En la segunda sesion eliminamos el objeto pais1,
        el presidente1 sera borrado en cascada */
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();

        sesion.delete(pais1);

        sesion.getTransaction().commit();
        sesion.close(); 
    } 
    
}

