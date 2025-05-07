package org.hstn.pharmacy.controller.productPharmacy;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.LovePotencyDTO;
import org.hstn.pharmacy.entity.entityProduct.LovePotency;
import org.hstn.pharmacy.service.serviceProduct.LovePotencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/love_potency")
public class LovePotencyController {

    private final LovePotencyService lovePotencyService;

@PostMapping
    public ResponseEntity<LovePotency> create(@RequestBody LovePotencyDTO lovePotencyDTO){
    return new ResponseEntity<>(lovePotencyService.create(lovePotencyDTO), HttpStatus.OK);
}

@GetMapping
    public ResponseEntity<List<LovePotency>> readAll(){
    return new ResponseEntity<>(lovePotencyService.readAll(), HttpStatus.OK);
}

@PutMapping
    public ResponseEntity<LovePotency> update(@RequestBody LovePotency lovePotency){
    return new ResponseEntity<>(lovePotencyService.update(lovePotency), HttpStatus.OK);
}

@DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
    lovePotencyService.delete(id);
    return HttpStatus.OK;
}
}

