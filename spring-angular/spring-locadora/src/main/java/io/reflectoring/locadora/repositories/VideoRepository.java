package io.reflectoring.locadora.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.reflectoring.locadora.models.VideoModel;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, UUID> {
    boolean existsByNome(String nome);
    Optional<VideoModel> findByNome(String nome);
}