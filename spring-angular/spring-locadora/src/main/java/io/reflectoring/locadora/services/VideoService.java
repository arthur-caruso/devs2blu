package io.reflectoring.locadora.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.reflectoring.locadora.models.VideoModel;
import io.reflectoring.locadora.repositories.VideoRepository;
import jakarta.transaction.Transactional;

@Service
public class VideoService {
	final VideoRepository videoRepository;

	public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

	@Transactional
	public void save(VideoModel video) {
		videoRepository.save(video);
	}

    @Transactional
	public void deleteById(UUID id) {
		videoRepository.deleteById(id);
	}

	public boolean existsByNome(String nome) {
		return videoRepository.existsByNome(nome);
	}

	public List<VideoModel> findAll() {
		return videoRepository.findAll();
	}

	public Optional<VideoModel> findById(UUID id) {
		return videoRepository.findById(id);
	}

	public Optional<VideoModel> findByNome(String nome) {
		return videoRepository.findByNome(nome);
	}
}
