package org.hstn.pharmacy.repository.repositoryProduct;

import org.hstn.pharmacy.entity.entityProduct.Laxative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaxativeRepository extends JpaRepository<Laxative, Long> {
}
