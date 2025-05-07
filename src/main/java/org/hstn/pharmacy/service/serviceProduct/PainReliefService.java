package org.hstn.pharmacy.service.serviceProduct;

import lombok.AllArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.PainReliefDTO;
import org.hstn.pharmacy.entity.entityProduct.PainRelief;
import org.hstn.pharmacy.repository.repositoryProduct.PainReliefRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PainReliefService {

    private final PainReliefRepository painReliefRepository;

    public PainRelief create(PainReliefDTO painReliefDTO){
        return painReliefRepository.save(PainRelief.builder()
                .name(painReliefDTO.getName())
                .pzn(painReliefDTO.getPzn())
                .amount(painReliefDTO.getAmount())
                .contain(painReliefDTO.getContain())
                .description(painReliefDTO.getDescription())
                .manufacturer(painReliefDTO.getManufacturer())
                .pharmaceuticalForm(painReliefDTO.getPharmaceuticalForm())
                .build());
    }
    public List<PainRelief> readAll(){
        return painReliefRepository.findAll();
    }
    public PainRelief update(PainRelief painRelief){
        return (painReliefRepository.save(painRelief));
    }
    public void delete(Long id){
        painReliefRepository.deleteById(id);
    }
}
