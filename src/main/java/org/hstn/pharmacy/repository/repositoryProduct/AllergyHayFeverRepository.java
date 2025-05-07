package org.hstn.pharmacy.repository.repositoryProduct;

import org.hstn.pharmacy.entity.entityProduct.AllergyHayFever;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyHayFeverRepository  extends JpaRepository<AllergyHayFever, Long> {
}
