package Class.Services.Implementation;

import Class.DTO.PurseDTO;
import Class.Entity.Purse;
import Class.Repository.PurseRepo;
import Class.Services.PurseSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by Ярослав on 31.08.2016.
 */
@Service
public class PurseSerImpl implements PurseSer {

    @Autowired
    private PurseRepo purseRepo;

    @Override
    public void addOrEdit(Purse purse) {
        purseRepo.save(purse);

    }

    @Override
    public void edit(int id_p, String name, double price, String description, MultipartFile multipartFile) {
        Purse purse = purseRepo.findOne(id_p);
        purse.setName(name);
        purse.setPrice(price);
        purse.setDescription(description);
        try {
            purse.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        purseRepo.save(purse);
    }

    @Override
    public void delete(int id_p) {
        purseRepo.delete(id_p);

    }

    @Override
    public PurseDTO findOne(int id_p) {
        Purse purse = purseRepo.findOne(id_p);
        PurseDTO purseDTO = new PurseDTO();
        purseDTO.setId_p(purse.getId_p());
        purseDTO.setName(purse.getName());
        purseDTO.setDescription(purse.getDescription());
        purseDTO.setPrice(purse.getPrice());
        String image = Base64.getEncoder().encodeToString(purse.getImage());
        purseDTO.setImage(image);

        return purseDTO;

    }

    @Override
    public Purse findOneById(int id_p) {
        return purseRepo.findOne(id_p);
    }

    @Override
    public List<PurseDTO> findAll() {
        List<PurseDTO>purseDTOs = new ArrayList<>();
        List<Purse>purseList = purseRepo.findAll();

        for (Purse purse:purseList){
            PurseDTO purseDTO = new PurseDTO();
            purseDTO.setId_p(purse.getId_p());
            purseDTO.setName(purse.getName());
            purseDTO.setDescription(purse.getDescription());
            purseDTO.setPrice(purse.getPrice());
            String image = Base64.getEncoder().encodeToString(purse.getImage());
            purseDTO.setImage(image);
            purseDTOs.add(purseDTO);

        }
        return purseDTOs;

    }

    @Override
    public List<PurseDTO> findByName(String name) {
        List<PurseDTO>purseDTOs = new ArrayList<>();
        List<Purse>purseList = purseRepo.findByName(name);

        for (Purse purse:purseList){
            PurseDTO purseDTO = new PurseDTO();
            purseDTO.setId_p(purse.getId_p());
            purseDTO.setName(purse.getName());
            purseDTO.setDescription(purse.getDescription());
            purseDTO.setPrice(purse.getPrice());
            String image = Base64.getEncoder().encodeToString(purse.getImage());
            purseDTO.setImage(image);
            purseDTOs.add(purseDTO);

        }
        return purseDTOs;

    }
}
