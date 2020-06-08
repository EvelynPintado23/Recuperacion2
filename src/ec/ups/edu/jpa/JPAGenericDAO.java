package ec.ups.edu.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;

	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("Recuperacion2").createEntityManager();
	}
	
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("INGRESANDO: /n");
			System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	@Override
	public T read(ID id) {
		// TODO Auto-generated method stub
		System.out.println("Buscando...");
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando.....");
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}	
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		System.out.println("ELIMINANDO...");
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	@Override
	public List<T> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(ID id) {
		// TODO Auto-generated method stub
		T entity = this.read(id);
		if (entity != null)
			this.delete(entity);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		List<T> lista = null;
		try {
			javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = em.createQuery(cq).getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public List<T> find(String[] attributes, String[] values, String order, int index, int size) {
		// TODO Auto-generated method stub
		// Se crea un criterio de consulta
				CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
				CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
				// Se establece la clausula FROM
				Root<T> root = criteriaQuery.from(this.persistentClass);
				// Se establece la clausula SELECT
				criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
				// // Se configuran los predicados,
				// combinados por AND
				Predicate predicate = criteriaBuilder.conjunction();
				for (int i = 0; i < attributes.length; i++) {
					Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
					// Predicate sig =
					// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
					// values[i]);
					predicate = criteriaBuilder.and(predicate, sig);
				}
				// Se establece el WHERE
				criteriaQuery.where(predicate);
				// Se establece el orden
				if (order != null)
					criteriaQuery.orderBy(criteriaBuilder.asc(root.get(order))); // Se
				// crea
				// el
				// resultado
				if (index >= 0 && size > 0) {
					TypedQuery<T> tq = em.createQuery(criteriaQuery);
					tq.setFirstResult(index);
					tq.setMaxResults(size); // Se realiza la query
					return tq.getResultList();
				} else {
					// Se realiza la query
					Query query = em.createQuery(criteriaQuery);
					return query.getResultList();
				}
	}

	@Override
	public T buscar(String[] attributes, String[] values) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Se crea un criterio de consulta
				CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
				CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
				// Se establece la clausula FROM
				Root<T> root = criteriaQuery.from(this.persistentClass);
				// Se establece la clausula SELECT
				criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
				// // Se configuran los predicados,
				// combinados por AND
				Predicate predicate = criteriaBuilder.conjunction();
				for (int i = 0; i < attributes.length; i++) {
					Predicate sig = criteriaBuilder.like(root.get(attributes[i]).as(String.class), values[i]);
					// Predicate sig =
					// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
					// values[i]);
					predicate = criteriaBuilder.and(predicate, sig);
				}
				// Predicate sig =
				// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
				// values[i]);

				criteriaQuery.where(predicate);

				Query query = em.createQuery(criteriaQuery);
				return (T) query.getSingleResult();
	}

	@Override
	public T buscar(String attributes, String values) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Se crea un criterio de consulta
				CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
				CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
				// Se establece la clausula FROM
				Root<T> root = criteriaQuery.from(this.persistentClass);
				// Se establece la clausula SELECT
				criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
				// // Se configuran los predicados,
				// combinados por AND
				Predicate predicate = criteriaBuilder.conjunction();

				Predicate sig = criteriaBuilder.like(root.get(attributes).as(String.class), values);
				// Predicate sig =
				// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
				// values[i]);
				predicate = criteriaBuilder.and(predicate, sig);

				// Predicate sig =
				// criteriaBuilder.like(root.get(attributes[i]).as(String.class),
				// values[i]);

				criteriaQuery.where(predicate);

				Query query = em.createQuery(criteriaQuery);
				return (T) query.getSingleResult();
	}

	@Override
	public List<T> find(String attributes, String values) {
		// TODO Auto-generated method stub
		return null;
	}

}
