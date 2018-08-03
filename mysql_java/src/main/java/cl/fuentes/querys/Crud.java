package cl.fuentes.querys;

public interface Crud<T> {
	
	public void create(T objeto);
	public T read(String valor);
	public void update(T objeto);
	public void delete(String valor);
	

}
