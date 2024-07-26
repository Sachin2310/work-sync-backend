package com.task.credmarg.worksync.email;

import com.task.credmarg.worksync.vendor.VendorDTO;
import com.task.credmarg.worksync.vendor.VendorManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DefaultEmailService implements EmailService{
    private final VendorManagementService vendorManagementService;
    private final Map<String,String> emailsSent = new HashMap<>();

    private static final String emailTemplate = """
        To: {email}
        Subject: payment receipt
        
        Dear {name},
        Your payment has been process with the below details,
        Vendor Name: {name}
        UPI id: {upi}
        Thank you for your continued partnership.
        
        Best regards,
        Sachin
        Solution Architect
        Credmarg
        """;

    @Override
    public List<VendorDTO> TriggerEmail(List<String> userIds) {
        var vendors = userIds.stream()
            .map(vendorManagementService::getVendorDetails)
            .toList();

        vendors.stream()
            .map(this::addVendorDetailsToTemplate)
            .forEach(System.out::println);

        return vendors;
    }

    private String addVendorDetailsToTemplate(VendorDTO vendorDTO) {
        var emailWithVendorDetails = emailTemplate
            .replace("{email}",vendorDTO.email())
            .replace("{name}",vendorDTO.name())
            .replace("{upi}",vendorDTO.upi());

        emailsSent.put(vendorDTO.id(), emailWithVendorDetails);
        return emailWithVendorDetails;
    }

    @Override
    public List<String> getAllTriggeredEmails() {
        return emailsSent.values().stream().toList();
    }
}
