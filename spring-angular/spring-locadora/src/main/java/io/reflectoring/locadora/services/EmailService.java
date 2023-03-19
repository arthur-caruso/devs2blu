package io.reflectoring.locadora.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import io.reflectoring.locadora.enums.EmailEnum;
import io.reflectoring.locadora.models.EmailModel;
import io.reflectoring.locadora.repositories.EmailRepository;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailModel emailModel) {
        emailModel.setSendDate(LocalDateTime.now());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailModel.getEmailFrom());
        message.setTo(emailModel.getEmailTo());
        message.setSubject(emailModel.getSubject());
        message.setText(emailModel.getText());

        try {
            emailSender.send(message);
        } catch (MailException e){
            emailModel.setStatus(EmailEnum.ERROR);
        } finally {
            emailModel.setStatus(EmailEnum.SENT);
            emailRepository.save(emailModel);
        }
    }
}
