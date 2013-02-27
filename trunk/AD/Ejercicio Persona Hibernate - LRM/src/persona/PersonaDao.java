package persona;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class PersonaDao {


	private static long id = 0;

	public PersonaDao() {}

	public Persona insertaPersona(String persona){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try{
			id = (Long) session.save(persona);
			tx.commit();
		} catch (HibernateException he) {
			tx.rollback();
			throw new HibernateException("Se ha producido un error de Hibernate Tools", he);
		}
		finally {
			session.close();
		}
		Persona res = new Persona(id, persona);
		return res;
	}

	public void borraPersona(String nomPersona) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Persona persona = null;
			boolean encontrado = false;
			for(int i = 0; i < obtienePersonas().size() && !encontrado; i++) {
				if(obtienePersonas().get(i).getNombre().equals(nomPersona)) {
					persona = obtienePersonas().get(i);
					encontrado = true;
				}
			}
			if(!encontrado)
				throw new NoSuchElementException();
			session.delete(persona);
			tx.commit();
		} catch (HibernateException he) {
			tx.rollback();
			throw new HibernateException("Se ha producido un error de Hibernate Tools", he);
		} finally {
			session.close();
		}
	}

	public Persona obtienePersona(long idPersona) {
		Persona persona = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			persona = (Persona) session.get(PersonaDao.class, idPersona);
			tx.commit();
		}
		finally {
			session.close();
		}
		return persona;
	}

	public List<Persona> obtienePersonas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("FROM PERSONA");
		session.close();
		return query.list();
	}

}
