package com.arthur.controle.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthur.controle.models.EmailModel;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {}
