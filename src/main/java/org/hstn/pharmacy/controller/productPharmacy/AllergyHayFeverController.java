package org.hstn.pharmacy.controller.productPharmacy;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.AllergyHayFeverDTO;
import org.hstn.pharmacy.entity.entityProduct.AllergyHayFever;
import org.hstn.pharmacy.service.serviceProduct.AllergyHayFeverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/allergy_hay_fever")
public class AllergyHayFeverController {

    private final AllergyHayFeverService allergyHayFeverService;

    @PostMapping
    public ResponseEntity<AllergyHayFever> create(@RequestBody AllergyHayFeverDTO allergyHayFeverDTO){
        return new ResponseEntity<>(allergyHayFeverService.create(allergyHayFeverDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AllergyHayFever>> readAll(){
        return new ResponseEntity<>(allergyHayFeverService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AllergyHayFever> update(@RequestBody AllergyHayFever allergyHayFever){
        return new ResponseEntity<>(allergyHayFeverService.update(allergyHayFever), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        allergyHayFeverService.delete(id);
        return HttpStatus.OK;
    }
}
