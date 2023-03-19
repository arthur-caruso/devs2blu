package com.arthur.controle.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.controle.models.EmailModel;
import com.arthur.controle.repositories.EmailRepository;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    public List<EmailModel> findAll() {
        return emailRepository.findAll();
    }

    public EmailModel save(EmailModel emailModel) {
       return emailRepository.save(emailModel);
    }
}
