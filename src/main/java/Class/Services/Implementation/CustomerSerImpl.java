package Class.Services.Implementation;

import Class.Entity.Customer;
import Class.Repository.CustomerRepo;
import Class.Services.CustomerSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
@Service
public class CustomerSerImpl implements CustomerSer, UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public void addOrEdit(Customer customer) {
        customerRepo.save(customer);

    }

    @Override
    public void delete(int id_c) {
        customerRepo.delete(id_c);

    }

    @Override
    public Customer findOneById(int id_c) {
        return customerRepo.findOne(id_c);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer;

        try {
            customer = (Customer) customerRepo.findByLogin(login);
        } catch (NoResultException e) {
            return null;
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(customer.getId_c()), customer.getPassword(), authorities);
    }

}
