package com.example.ms.msemail.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.ms.msemail.enums.EmailStatus;
import com.example.ms.msemail.models.EmailModel;
import com.example.ms.msemail.repositories.EmailRepository;

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
        } catch (MailException e) {
            emailModel.setEmailStatus(EmailStatus.ERROR);
        } finally {
            emailModel.setEmailStatus(EmailStatus.SENT);
            emailRepository.save(emailModel);
        }
    }
}
