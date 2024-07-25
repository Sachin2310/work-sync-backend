package com.task.credmarg.worksync.email;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @PostMapping
    ResponseEntity<String> triggerEmailToUsers(@RequestBody List<String> userIds){
        emailService.TriggerEmail(userIds);
        return ResponseEntity.ok("Email has been sent to selected vendors");
    }

    @GetMapping
    ResponseEntity<List<String>> getAllTriggeredEmails(){
        return ResponseEntity.ok(emailService.getAllTriggeredEmails());
    }
}
