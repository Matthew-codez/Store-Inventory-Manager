package Repository;

public interface IRepository <T> {
    public void create(T entity);
    T read(String id);
    public void update(T entity);
    public void delete(String id);
}
