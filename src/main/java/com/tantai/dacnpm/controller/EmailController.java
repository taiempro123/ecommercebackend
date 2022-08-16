package com.tantai.dacnpm.controller;

import com.tantai.dacnpm.request.PushEmailRequest;
import com.tantai.dacnpm.service.Mail.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email/")
@CrossOrigin
public class EmailController {
    @Autowired
    private  SendEmailService sendEmailService;

    @PostMapping("pushEmail")
    public ResponseEntity<?> pushEmail(@Valid @RequestBody PushEmailRequest pushEmailRequest) {
        sendEmailService.sendEmails(pushEmailRequest.getEMail(), pushEmailRequest.getBody(), pushEmailRequest.getTitle());
        return ResponseEntity.ok("success");
    }

}
