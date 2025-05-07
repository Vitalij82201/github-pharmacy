package org.hstn.pharmacy.service;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.entity.entityUser.ConfirmationCode;
import org.hstn.pharmacy.entity.entityUser.User;
import org.hstn.pharmacy.exceptions.NotFoundException;
import org.hstn.pharmacy.repository.repositoryUser.ConfirmationCodeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmationCodeService {

    private final ConfirmationCodeRepository confirmationCodeRepository;


    public String createConfirmationCode(User user) {
        String newConfirmationCode = UUID.randomUUID().toString();

        ConfirmationCode code = ConfirmationCode.builder()
                .code(newConfirmationCode)
                .user(user)
                .expiredDateTime(LocalDateTime.now().plusDays(1))
                .build();

        confirmationCodeRepository.save(code);

        return newConfirmationCode;
    }

    public ConfirmationCode findByCode(String code){
        return confirmationCodeRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Confirmation code not found or expired"));
    }

    public ConfirmationCode findByCodeExpireDateTimeAfter(String code, LocalDateTime date){
        return confirmationCodeRepository.findByCodeAndExpiredDateTimeAfter(code,date)
                .orElseThrow(() -> new NotFoundException("Confirmation code not found or expired"));
    }
}
