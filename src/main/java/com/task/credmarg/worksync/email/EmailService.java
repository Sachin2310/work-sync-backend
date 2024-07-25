package com.task.credmarg.worksync.email;

import java.util.List;

public interface EmailService {
    void TriggerEmail(List<String> userIds);

    List<String> getAllTriggeredEmails();
}
