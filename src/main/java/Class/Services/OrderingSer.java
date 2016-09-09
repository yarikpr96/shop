package Class.Services;

import Class.Entity.Ordering;

import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
public interface OrderingSer {
    void addOrEdit(Ordering ordering);

    void delete(int id_o);

    Ordering findOneById(int id_o);

    List<Ordering> findAll();
    List<Ordering> findLast();
}
