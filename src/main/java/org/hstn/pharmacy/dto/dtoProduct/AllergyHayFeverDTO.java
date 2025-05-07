package org.hstn.pharmacy.dto.dtoProduct;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllergyHayFeverDTO {
    private Short amount;
    private String contain;
    private String description;
    private String manufacturer;
    private String name;
    private String pharmaceuticalForm;

    private String pzn;




}
