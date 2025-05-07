package org.hstn.pharmacy.controller.productPharmacy;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.PainReliefDTO;
import org.hstn.pharmacy.entity.entityProduct.PainRelief;
import org.hstn.pharmacy.service.serviceProduct.PainReliefService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pain_relief")
public class PainReliefController {

    private final PainReliefService painReliefService;

    @PostMapping
    public ResponseEntity<PainRelief> create(@RequestBody PainReliefDTO painReliefDTO){
        return new ResponseEntity<>(painReliefService.create(painReliefDTO), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PainRelief>> readAll(){
        return new ResponseEntity<>(painReliefService.readAll(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<PainRelief> update(@RequestBody PainRelief painRelief){
        return new ResponseEntity<>(painReliefService.update(painRelief), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        painReliefService.delete(id);
        return HttpStatus.OK;
    }
}
