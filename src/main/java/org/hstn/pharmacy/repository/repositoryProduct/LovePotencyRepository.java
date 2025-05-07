package org.hstn.pharmacy.repository.repositoryProduct;

import org.hstn.pharmacy.entity.entityProduct.LovePotency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LovePotencyRepository extends JpaRepository<LovePotency, Long> {
}
