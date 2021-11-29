package com.daiancosta.ms.notification.adapters.inbound.controllers;

import com.daiancosta.ms.notification.adapters.inbound.dtos.EmailDto;
import com.daiancosta.ms.notification.application.domain.Email;
import com.daiancosta.ms.notification.application.domain.PageInfo;
import com.daiancosta.ms.notification.application.ports.EmailServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/notification")
public class EmailController {

    @Autowired
    EmailServicePort emailServicePort;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        return new ResponseEntity<>(emailServicePort.sendEmail(email), HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<Email>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId",
            direction = Sort.Direction.DESC) Pageable pageable){
        final PageInfo pageInfo = new PageInfo();

        BeanUtils.copyProperties(pageable, pageInfo);

        final List<Email> emailList = emailServicePort.findAll(pageInfo);

        return new ResponseEntity<>(new PageImpl<>(emailList, pageable, emailList.size()), HttpStatus.OK);
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity<Object> getOneEmail(@PathVariable(value="emailId") UUID emailId){
        Optional<Email> emailModelOptional = emailServicePort.findById(emailId);
        if(!emailModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(emailModelOptional.get());
        }
    }
}
