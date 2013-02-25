package dominio.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class PersonaDao1 {
	
	private Session session;
	private Transaction tx;
	private static long id = 0;
	private static SessionFactory sessionFactory;
	
	public PersonaDao1() {}
	
	public Persona insertaPersona(String persona){
		try{
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(persona);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		Persona res = new Persona(id, persona);
		return res;
	}
	
	public void borraPersona(String nomPersona) {
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
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.delete(persona);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Persona obtienePersona(long idPersona) {
		Persona persona = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			persona = (Persona) session.get(PersonaDao1.class, idPersona);
			tx.commit();
		} finally {
			session.close();
		}
		return persona;
	}
	
	public List<Persona> obtienePersonas() {
		session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM PERSONA");
		session.close();
		return query.list();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Se ha producido un error de Hibernate Tools", he);
	}

}
