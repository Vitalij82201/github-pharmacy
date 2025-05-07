package org.hstn.pharmacy.service.mail;

import lombok.RequiredArgsConstructor;
import org.hstn.pharmacy.entity.entityUser.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMailSender {

    private final MailCreateUtil mailCreateUtil;
    private final JavaMailSender javaMailSender;

    public void sendEmail(User user, String confirmationCode){
        String html = mailCreateUtil.createConfirmationMail(user.getFirstName(), user.getLastName(), confirmationCode);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        try{
            helper.setTo(user.getEmail());
            helper.setSubject("Registration Confirmation");
            helper.setText(html,true);
        } catch (MessagingException e){
            throw new IllegalStateException("Error while sending email", e);
        }

        javaMailSender.send(message);

    }
}
