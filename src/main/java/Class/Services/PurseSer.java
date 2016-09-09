package Class.Services;

import Class.DTO.PurseDTO;
import Class.Entity.Purse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface PurseSer {
    void addOrEdit(Purse purse);

    void edit(int id_p, String name, double price, String description, MultipartFile multipartFile);

    void delete(int id_p);

    PurseDTO findOne(int id_p);

    Purse findOneById(int id_p);

    List<PurseDTO> findAll();

    List<PurseDTO> findByName(String name);
}
