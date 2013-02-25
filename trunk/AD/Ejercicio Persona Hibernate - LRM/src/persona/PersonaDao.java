package persona;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class PersonaDao {

	private static Session session = HibernateUtil.getSessionFactory().openSession();
	private static Transaction tx = session.beginTransaction();
	private static long id = 0;

	public PersonaDao() {}

	public Persona insertaPersona(String persona){
		try{
			id = (Long) session.save(persona);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
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
			session.delete(persona);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}
	}

	public Persona obtienePersona(long idPersona) {
		Persona persona = null;
		persona = (Persona) session.get(PersonaDao.class, idPersona);
		tx.commit();
		return persona;
	}

	public List<Persona> obtienePersonas() {
		Query query = session.createQuery("FROM PERSONA");
		return query.list();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Se ha producido un error de Hibernate Tools", he);
	}

}
