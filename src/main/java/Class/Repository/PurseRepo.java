package Class.Repository;

import Class.Entity.Purse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
public interface PurseRepo extends JpaRepository<Purse,Integer> {
    @Query("FROM Purse ")
    List<Purse> findAll ();
    @Query("from Purse p where p.name LIKE :name")
    List<Purse> findByName (@Param("name")String name);
}
