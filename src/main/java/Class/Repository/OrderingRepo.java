package Class.Repository;

import Class.Entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
public interface OrderingRepo extends JpaRepository<Ordering, Integer> {
    @Query("FROM Ordering ")
    List<Ordering> findAll();

    @Query("FROM Ordering  order by date  desc ")
    List<Ordering> findLast();
}