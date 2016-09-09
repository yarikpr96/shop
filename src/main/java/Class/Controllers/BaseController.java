package Class.Controllers;


import Class.DTO.PurseDTO;
import Class.Entity.*;
import Class.Services.*;
import Class.Validations.CustomersVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
@Controller
public class BaseController {
    @Autowired
    private CustomerSer customerSer;
    @Autowired
    private OrderingSer orderingSer;
    @Autowired
    private PurseSer purseSer;
    @Autowired
    private CustomersVal customersVal;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String home() {
        return "views-base-home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    private String about() {
        return "views-other-about";
    }

    @RequestMapping(value = "/ourWork", method = RequestMethod.GET)
    private String ourWork() {
        return "views-other-ourWork";
    }

    @RequestMapping(value = "/newPurse", method = RequestMethod.GET)
    private String newPurse() {
        return "views-purse-newPurse";
    }

    @RequestMapping(value = "/newPurse", method = RequestMethod.POST)
    public String createPizza(@RequestParam("name") String name, @RequestParam("price") double price, @RequestParam("description") String description, @RequestParam("image") MultipartFile multipartFile) {
        Purse purse = new Purse();
        purse.setName(name);
        purse.setDescription(description);
        purse.setPrice(price);
        try {
            purse.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        purseSer.addOrEdit(purse);
        return "redirect:/allPurse";
    }

    @RequestMapping(value = "/allPurse", method = RequestMethod.GET)
    private String allPurse(Model model) {
        List<PurseDTO> purseDTOList = purseSer.findAll();
        model.addAttribute("purse", purseDTOList);
        return "views-purse-allPurse";
    }

    @RequestMapping(value = "/purseEdit/{id_p}", method = RequestMethod.GET)
    public String purseEdit(@PathVariable String id_p, Model model) {
        model.addAttribute("purse", purseSer.findOne(Integer.parseInt(id_p)));
        return "views-purse-purseEdit";
    }

    @RequestMapping(value = "/purseEdit", method = RequestMethod.POST)
    public String purseEdit(@RequestParam("id_p") int id_p, @RequestParam("name") String name,
                            @RequestParam("price") double price, @RequestParam("description") String description,
                            @RequestParam("image") MultipartFile multipartFile) {
        purseSer.edit(id_p, name, price, description, multipartFile);
        return "redirect:/allPurse";
    }

    @RequestMapping(value = "/purse/delete/{id_p}", method = RequestMethod.POST)
    public String delete(@PathVariable String id_p) {
        purseSer.delete(Integer.parseInt(id_p));
        return "redirect:/allPurse";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login() {
        return "views-base-login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("customer", new Customer());
        return "views-base-registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute Customer customer, BindingResult bindingResult) {
        customersVal.validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "views-base-registration";
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            customerSer.addOrEdit(customer);
            return "redirect:/";
        }
    }

    //додати гаманець в замовлення
    @RequestMapping(value = "/purse/{id_p}", method = RequestMethod.GET)
    public String addToBasket(HttpSession httpSession, @PathVariable String id_p) {
        List<Purse> purses = (List<Purse>) httpSession.getAttribute("purses");
        Purse purse = purseSer.findOneById(Integer.parseInt(id_p));
        if (purses == null) {
            purses = new ArrayList<Purse>();
        }
        purses.add(purse);
        httpSession.setAttribute("purses", purses);
        return "redirect:/allPurse";
    }

    //все замовлення
    @RequestMapping(value = "/purse", method = RequestMethod.GET)
    private String addToBasket(HttpSession httpSession, Model model) {
        List<Purse> purses = (List<Purse>) httpSession.getAttribute("purses");
        if (purses == null) {
            purses = new ArrayList<Purse>();
        }
        double d = 0;
        for (Purse p : purses) {
            d += p.getPrice();
        }
        model.addAttribute("price", d);
        model.addAttribute("purses", purses);
        return "views-purse-purse";
    }


    //очистити всю корзину
    @RequestMapping(value = "/pursedel", method = RequestMethod.POST)
    public String dellBasket(HttpSession httpSession) {
        List<Purse> purses = (List<Purse>) httpSession.getAttribute("purses");
        httpSession.removeAttribute("purses");
        return "redirect:/allPurse";
    }

    //видалити з  корзини
    @RequestMapping(value = "/pursedell/{id_p}", method = RequestMethod.POST)
    public String dellBasketid(HttpSession httpSession, @PathVariable String id_p) {
        List<Purse> purses = (List<Purse>) httpSession.getAttribute("purses");
        Purse purse1 = purseSer.findOneById(Integer.parseInt(id_p));
        Iterator<Purse> iter = purses.iterator();
        int count = 0;
        while (iter.hasNext()) {
            if (iter.next().getId_p() == purse1.getId_p() && (count == 0)) {
                iter.remove();
                count++;
            }
            purses = (List<Purse>) httpSession.getAttribute("purses");
        }
        return "redirect:/purse";
    }

    //додати замовлення
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String addToData(HttpSession httpSession, @ModelAttribute Ordering ordering, Principal principal) {
        List<Purse> purseList = (List<Purse>) httpSession.getAttribute("purses");
        if (purseList == null) {
            purseList = new ArrayList<Purse>();
        }

        ordering.setPurseList(purseList);
        ordering.setCustomer(customerSer.findOneById(Integer.parseInt(principal.getName())));
        ordering.setSum((double) 0);
        for (Purse o : purseList) {
            ordering.setSum((double) ordering.getSum() + (double) o.getPrice());
        }
        for (Purse p : purseList) {
            if (p != null) {
                orderingSer.addOrEdit(ordering);
                httpSession.removeAttribute("purses");
            }
        }
        return "redirect:/oneOrder";
    }

    @RequestMapping(value = "/allOrder", method = RequestMethod.GET)
    private String allOrder(Model model) {
        List<Ordering> orderingList = orderingSer.findAll();
        if (orderingList == null) {
            orderingList = new ArrayList<Ordering>();
        }
        model.addAttribute("order", orderingList);
        return "views-ordering-allOrder";

    }

    @RequestMapping(value = "/allOrder/delete/{id_o}", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable String id_o) {
        orderingSer.delete(Integer.parseInt(id_o));
        return "redirect:/allOrder";
    }

    @RequestMapping(value = "/oneOrder", method = RequestMethod.GET)
    private String oneOrder(Model model, Principal principal) {
        List<Ordering> orderingList = orderingSer.findLast();
        List<Ordering> orderingListOne = new ArrayList<Ordering>();
        if (orderingList == null) {
            orderingList = new ArrayList<Ordering>();
        }
        int count = 0;
        for (Ordering o : orderingList) {
            if (o.getCustomer().getId_c() == Integer.parseInt(principal.getName()) && count < 1) {
                orderingListOne.add(o);
                count++;
            }
        }
        model.addAttribute("order", orderingListOne);
        return "views-ordering-oneOrder";

    }
    @RequestMapping ( value = "/cabinet", method = RequestMethod.GET )
    public String cabinet(Principal principal, Model model) {
        model.addAttribute("customer", customerSer.findOneById(Integer.parseInt(principal.getName())));
        return "views-base-cabinet";
    }




}
