package io.reflectoring.locadora.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.locadora.dtos.VideoDTO;
import io.reflectoring.locadora.enums.GeneroEnum;
import io.reflectoring.locadora.models.VideoModel;
import io.reflectoring.locadora.services.VideoService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/videos")
public class VideoController {
	@Autowired
	private VideoService videoService;

	public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
	public ResponseEntity<Object> saveVideo(@RequestBody @Valid VideoDTO videoDTO) {

		if (videoService.existsByNome(videoDTO.getNome())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICT: Video já existe!");
		} else {
            var videoModel = new VideoModel();

			BeanUtils.copyProperties(videoDTO, videoModel);

			try {
				videoModel.setGenero(GeneroEnum.valueOf(videoDTO.getNomeGenero()));
			} catch (IllegalArgumentException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Genero não encontrado!");
			}

            videoService.save(videoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(videoModel);
		}
	}

	@GetMapping
	public ResponseEntity<List<VideoModel>> getAllVideos() {
		return ResponseEntity.status(HttpStatus.OK).body(videoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getVideo(@PathVariable(value = "id") UUID id) {
		Optional<VideoModel> videoModelOptional = videoService.findById(id);

		if (!videoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Video não encontrado!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(videoModelOptional.get());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVideo(@PathVariable(value = "id") UUID id) {
		Optional<VideoModel> videoModelOptional = videoService.findById(id);

		if (!videoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Video não encontrado!");
		} else {
			videoService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("OK: video deletado com sucesso!");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updatevideo(	@PathVariable(value = "id") UUID id,
												@RequestBody @Valid VideoDTO videoDTO) {
		Optional<VideoModel> videoModelOptional = videoService.findById(id);
		if (!videoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Video não encontrado!");
		} else {
			var videoModel = videoModelOptional.get();
			BeanUtils.copyProperties(videoDTO, videoModel);

			try {
				videoModel.setGenero(GeneroEnum.valueOf(videoDTO.getNomeGenero()));
			} catch (IllegalArgumentException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT_FOUND: Genero não encontrado!");
			}

			videoModel.setId(videoModelOptional.get().getId());
			videoService.save(videoModel);
			return ResponseEntity.status(HttpStatus.OK).body(videoModel);
		}
	}
}
