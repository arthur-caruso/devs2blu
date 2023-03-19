package io.reflectoring.locadora.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.locadora.dtos.LocacaoDTO;
import io.reflectoring.locadora.models.EmailModel;
import io.reflectoring.locadora.models.VideoModel;
import io.reflectoring.locadora.services.EmailService;
import io.reflectoring.locadora.services.VideoService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/locacao")
public class LocacaoController {
    @Autowired
    private VideoService videoService;

    @Autowired
    private EmailService emailService;

    public LocacaoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public ResponseEntity<Object> alugarVideo(@RequestBody @Valid LocacaoDTO locacaoDTO) {
        Optional<VideoModel> videoModelOptional = videoService.findByNome(locacaoDTO.getNomeVideo());

        if (!videoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Video não encontrado!");
        }
            var videoModel = videoModelOptional.get();

        if (videoModel.getExemplares() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD_REQUEST: Video não possui exemplares para locação!");
        }

        // set exemplares to exemplares - 1
        videoModel.setExemplares(videoModel.getExemplares() - 1);
        videoService.save(videoModel);

        // send acknowledgement email
        EmailModel emailModel = new EmailModel();
        emailModel.setEmailFrom("test@test");
        emailModel.setEmailTo(locacaoDTO.getEmailLocatario());
        emailModel.setSubject("Locação do vídeo \"" + locacaoDTO.getNomeVideo() + "\"");
        emailModel.setText(
            "Olá, dono(a) do email \"" +
            locacaoDTO.getEmailLocatario() +
            "\", o vídeo \"" +
            locacaoDTO.getNomeVideo() +
            "\" foi alugado no dia \"" +
            LocalDateTime.now() + "\"."
        );

        emailService.sendEmail(emailModel);
        return ResponseEntity.status(HttpStatus.OK).body(videoModel);
    }
}
