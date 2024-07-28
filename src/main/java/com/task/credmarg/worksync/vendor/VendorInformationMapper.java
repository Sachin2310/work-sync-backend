package com.task.credmarg.worksync.vendor;

import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import org.springframework.stereotype.Service;

@Service
public class VendorInformationMapper {
    public VendorDTO vendorDetailsToVendorDto(VendorDetails vendorDetails) {
        return new VendorDTO(
            vendorDetails.getId(),
            vendorDetails.getName(),
            vendorDetails.getEmail(),
            vendorDetails.getUpi());
    }

    public VendorDetails vendorDtoToVendorDetails(VendorDTO vendorDTO) {
        return VendorDetails.builder()
            .id(vendorDTO.getId())
            .name(vendorDTO.getName())
            .email(vendorDTO.getEmail())
            .upi(vendorDTO.getUpi())
            .build();
    }
}
