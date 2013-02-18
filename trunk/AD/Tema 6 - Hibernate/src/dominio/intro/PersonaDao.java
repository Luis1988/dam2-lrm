package dominio.intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class PersonaDao {
	
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		Session session = null;
		long id = 0;
		
		try {
			try {
				sessionFactory = HibernateUtil.getSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Fallo al crear el objeto sessionFactory. "+ex);
				throw new ExceptionInInitializerError(ex);
			}
			session = sessionFactory.openSession();
			Persona persona = new Persona();
			System.out.println("Insertando registro");
			Transaction tx = session.beginTransaction();
			persona.setNombre("Carmen");
			id = (Long) session.save(persona);
			
			tx.commit();
			System.out.println("Hecho");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
	}

}
