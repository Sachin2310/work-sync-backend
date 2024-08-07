package com.task.credmarg.worksync.email;

import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import java.util.List;

public interface EmailService {
    List<VendorDTO> TriggerEmail(List<Integer> userIds);

    List<String> getAllTriggeredEmails();
}
