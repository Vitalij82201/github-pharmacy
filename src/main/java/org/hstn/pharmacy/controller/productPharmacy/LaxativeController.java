package org.hstn.pharmacy.controller.productPharmacy;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.dto.dtoProduct.LaxativeDTO;
import org.hstn.pharmacy.entity.entityProduct.Laxative;
import org.hstn.pharmacy.service.serviceProduct.LaxativeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/laxative")
public class LaxativeController {

    private final LaxativeService laxativeService;

    @PostMapping
    public ResponseEntity<Laxative> create(@RequestBody LaxativeDTO laxativeDTO){
        return new ResponseEntity<>(laxativeService.create(laxativeDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Laxative>> readAll(){
        return new ResponseEntity<>(laxativeService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Laxative> update(@RequestBody Laxative laxative){
        return new ResponseEntity<>(laxativeService.update(laxative), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        laxativeService.delete(id);
        return HttpStatus.OK;
    }
}
