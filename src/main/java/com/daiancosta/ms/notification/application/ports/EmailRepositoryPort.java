package com.daiancosta.ms.notification.application.ports;

import com.daiancosta.ms.notification.application.domain.Email;
import com.daiancosta.ms.notification.application.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {

    Email save(Email email);
    List<Email> findAll(PageInfo pageInfo);
    Optional<Email> findById(UUID emailId);
}
