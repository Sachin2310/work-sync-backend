package com.task.credmarg.worksync.email;

import com.task.credmarg.worksync.vendor.VendorDTO;

import java.util.List;

public interface EmailService {
    List<VendorDTO> TriggerEmail(List<String> userIds);

    List<String> getAllTriggeredEmails();
}
