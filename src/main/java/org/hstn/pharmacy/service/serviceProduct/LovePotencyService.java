package org.hstn.pharmacy.service.serviceProduct;

import lombok.AllArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.LovePotencyDTO;
import org.hstn.pharmacy.entity.entityProduct.LovePotency;
import org.hstn.pharmacy.repository.repositoryProduct.LovePotencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class LovePotencyService {

    private final LovePotencyRepository lovePotencyRepository;

    public LovePotency create(LovePotencyDTO lovePotencyDTO){
        return lovePotencyRepository.save(LovePotency.builder()
                        .name(lovePotencyDTO.getName())
                        .pzn(lovePotencyDTO.getPzn())
                        .amount(lovePotencyDTO.getAmount())
                        .contain(lovePotencyDTO.getContain())
                        .description(lovePotencyDTO.getDescription())
                        .manufacturer(lovePotencyDTO.getManufacturer())
                        .pharmaceuticalForm(lovePotencyDTO.getPharmaceuticalForm())
                .build());
    }
    public List<LovePotency> readAll(){
        return lovePotencyRepository.findAll();
    }
    public LovePotency update(LovePotency lovePotency){
        return lovePotencyRepository.save(lovePotency);
    }
    public void delete(Long id){
        lovePotencyRepository.deleteById(id);
    }
}
