package com.daiancosta.ms.notification.adapters.outbound.persistence.repositories;

import com.daiancosta.ms.notification.adapters.outbound.persistence.entities.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresEmailRepository extends JpaRepository<EmailEntity, UUID> {
}
