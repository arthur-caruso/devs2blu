package io.reflectoring.locadora.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.reflectoring.locadora.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
