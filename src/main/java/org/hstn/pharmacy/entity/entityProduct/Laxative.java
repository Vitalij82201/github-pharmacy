package org.hstn.pharmacy.entity.entityProduct;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Laxative")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laxative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String manufacturer;


    private String contain;


    private String pzn;

    private String pharmaceuticalForm;

    private String description;


    private Short amount;
}
