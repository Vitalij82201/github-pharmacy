package org.hstn.pharmacy.repository.repositoryUser;

import org.hstn.pharmacy.entity.entityUser.ConfirmationCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Integer> {

    Optional<ConfirmationCode> findByCodeAndExpiredDateTimeAfter(String code, LocalDateTime now);
    Optional<ConfirmationCode> findByCode(String code);
}
