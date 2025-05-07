package org.hstn.pharmacy.service.serviceProduct;

import lombok.AllArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.LaxativeDTO;
import org.hstn.pharmacy.entity.entityProduct.Laxative;
import org.hstn.pharmacy.repository.repositoryProduct.LaxativeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class LaxativeService {

    private final LaxativeRepository laxativeRepository;

    public Laxative create(LaxativeDTO laxativeDTO){
        return laxativeRepository.save(Laxative.builder()
                .pharmaceuticalForm(laxativeDTO.getPharmaceuticalForm())
                .description(laxativeDTO.getDescription())
                .pzn(laxativeDTO.getPzn())
                .name(laxativeDTO.getName())
                .amount(laxativeDTO.getAmount())
                .contain(laxativeDTO.getContain())
                .manufacturer(laxativeDTO.getManufacturer())
                .build());
    }
    public List<Laxative> readAll(){
        return laxativeRepository.findAll();
    }
    public Laxative update(Laxative laxative){
        return laxativeRepository.save(laxative);
    }
    public void delete(Long id){
        laxativeRepository.deleteById(id);
    }
}
