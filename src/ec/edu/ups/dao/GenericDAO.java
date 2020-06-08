package ec.edu.ups.dao;

import java.util.List;

public interface GenericDAO <T, ID> {
	
	public void createTable();

	public void create(T entity);

	public T read(ID id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();
	
	void deleteByID(ID id);

	List<T> findAll();

	List<T> find(String[] attributes, String[] values, String order, int index, int size);

	public T buscar(String[] attributes, String[] values);

	T buscar(String attributes, String values);

	public List<T> find(String attributes, String values);


}
