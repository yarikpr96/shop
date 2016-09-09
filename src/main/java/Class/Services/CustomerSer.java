package Class.Services;

import Class.Entity.Customer;

import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
public interface CustomerSer {
    void addOrEdit(Customer customer);
    void delete(int id_c);
    Customer findOneById(int id_c);
    List<Customer> findAll();

}
