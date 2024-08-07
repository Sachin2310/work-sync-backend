package com.task.credmarg.worksync.email;

import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    ResponseEntity<List<VendorDTO>> triggerEmailToUsers(@RequestBody List<Integer> userIds) {
        return ResponseEntity.ok(emailService.TriggerEmail(userIds));
    }

    @GetMapping
    ResponseEntity<List<String>> getAllTriggeredEmails() {
        return ResponseEntity.ok(emailService.getAllTriggeredEmails());
    }
}
