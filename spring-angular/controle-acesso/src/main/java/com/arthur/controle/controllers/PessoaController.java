package com.arthur.controle.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.controle.dtos.PessoaDTO;
import com.arthur.controle.enums.NivelEnum;
import com.arthur.controle.enums.StatusEnum;
import com.arthur.controle.models.EmailModel;
import com.arthur.controle.models.PessoaModel;
import com.arthur.controle.services.EmailService;
import com.arthur.controle.services.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mansao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping
    public ResponseEntity<Object> registrarEntrada(@RequestBody @Valid PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();

        BeanUtils.copyProperties(pessoaDTO, pessoaModel);
        pessoaModel.setDataEntrada(LocalDateTime.now());

        var emailModel = new EmailModel();


        String assunto;
        String texto;

        switch (pessoaModel.getEspecie()) {
            case SAPIENS:
            case PEREGRINO:
                assunto = "Alerta! Alerta! Alerta!";
                texto = pessoaModel.getNome() + " entrou na mansão de mutantes!";
                emailModel.setDe("defcon@xmen.org");
                emailModel.setPara("charlesXavier@gmail.com");
                break;

            case SUPERIOR:
                assunto = "Boas Vindas!";
                texto = "Bem vindo(a) de volta, Sr(a) " + pessoaModel.getNome();
                emailModel.setDe("charlesXavier@gmail.com");
                emailModel.setPara(pessoaModel.getEmail());
                break;
            
            default:
                assunto = "Alerta! Alerta! Alerta!";
                texto = "ser desconhecido entrou na mansão de mutantes! (é o magneto)";
                emailModel.setDe("defcon@xmen.org");
                emailModel.setPara("charlesXavier@gmail.com");
                break;
        }
        emailModel.setAssunto(assunto);
        emailModel.setTexto(texto);
        emailModel.setDataEnvio(LocalDateTime.now());

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailModel.getDe());
        message.setTo(emailModel.getPara());
        message.setSubject(emailModel.getAssunto());
        message.setText(emailModel.getTexto());

        try {
            emailSender.send(message);
            emailModel.setStatus(StatusEnum.ENVIADO);
        } catch (MailException e){
            emailModel.setStatus(StatusEnum.ERRO);
        }

        emailService.save(emailModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }

    @PutMapping("/saida/{id}")
    public ResponseEntity<Object> registrarSaida(@PathVariable(value = "id") UUID id){
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(id);

        if (pessoaModelOptional.isPresent()){
            PessoaModel pessoaModel =  pessoaModelOptional.get();
            pessoaModel.setDataSaida(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Olha só, não encontramos nenhuma pessoa com esse ID");
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getPessoas(){

        var emailModel = new EmailModel();

        emailModel.setDe("defcon@xmen.org");
        emailModel.setPara("charlesXavier@gmail.com");
        emailModel.setDataEnvio(LocalDateTime.now());
        emailModel.setAssunto("Relatório de acesso");
        emailModel.setTexto("Bom dia Dr. Charles Xavier. O relatório de defesa segue em anexo: " + pessoaService.findAll());

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(emailModel.getDe());
        message.setTo(emailModel.getPara());
        message.setSubject(emailModel.getAssunto());
        message.setText(emailModel.getTexto());

        try {
            emailSender.send(message);
            emailModel.setStatus(StatusEnum.ENVIADO);
        } catch (MailException e){
            emailModel.setStatus(StatusEnum.ERRO);
        }

        emailService.save(emailModel);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable(value = "id") UUID id){
        Optional<PessoaModel> pessoaModelOptional =  pessoaService.findById(id);

        if(pessoaModelOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID nao foi encontrado!!!");
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity<List<PessoaModel>> getPessoasByNivel(@PathVariable(value = "nivel") NivelEnum nivel){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAllByNivel(nivel));
    }
}
