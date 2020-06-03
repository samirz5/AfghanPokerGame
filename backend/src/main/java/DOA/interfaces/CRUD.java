package DOA.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {
    void createTable() throws SQLException;
    void add(T entity);
    T selectById(int id) throws SQLException;
    void update(T entity, int id);
    void delete(int id);
    List<T> getAll() throws SQLException;
}
