package org.hstn.pharmacy.service.serviceProduct;

import lombok.AllArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.AllergyHayFeverDTO;
import org.hstn.pharmacy.entity.entityProduct.AllergyHayFever;
import org.hstn.pharmacy.repository.repositoryProduct.AllergyHayFeverRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class AllergyHayFeverService {

    private final AllergyHayFeverRepository allergyHayFeverRepository;

    public AllergyHayFever create(AllergyHayFeverDTO allergyHayFeverDTO) {
        return allergyHayFeverRepository.save(AllergyHayFever.builder()
                .amount(allergyHayFeverDTO.getAmount())
                .contain(allergyHayFeverDTO.getContain())
                        .description(allergyHayFeverDTO.getDescription())
                        .manufacturer(allergyHayFeverDTO.getManufacturer())
                        .name(allergyHayFeverDTO.getName())
                        .pharmaceuticalForm(allergyHayFeverDTO.getPharmaceuticalForm())
                        .pzn(allergyHayFeverDTO.getPzn())
                .build());
    }

    public List<AllergyHayFever> readAll(){
        return allergyHayFeverRepository.findAll();
    }

    public AllergyHayFever update(AllergyHayFever allergyHayFever){
        return allergyHayFeverRepository.save(allergyHayFever);
    }

    public void delete(Long id){
        allergyHayFeverRepository.deleteById(id);
    }
}
