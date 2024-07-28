package com.task.credmarg.worksync.vendor;

import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import com.task.credmarg.worksync.vendor.models.VendorDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultVendorManagementService implements VendorManagementService{
    Map<Integer,VendorDetails> vendors = new HashMap<>();

    @Override
    public VendorDTO addVendorDetails(VendorDTO vendorDTO) {
        VendorDetails vendorDetails = mapVendorDtoToVendorDetails(vendorDTO);
        vendors.put(vendorDetails.getId(), vendorDetails);
        return vendorDTO;
    }

    private VendorDetails mapVendorDtoToVendorDetails(VendorDTO vendorDTO) {
        return VendorDetails.builder()
            .id(vendorDTO.getId())
            .name(vendorDTO.getName())
            .email(vendorDTO.getEmail())
            .upi(vendorDTO.getUpi())
            .build();
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendors.values()
            .stream()
            .map(this::mapVendorDetailsToVendorDto)
            .toList();
    }

    @Override
    public VendorDTO getVendorDetails(int vendorId) {
        return vendors.keySet()
            .stream()
            .filter(id -> id.equals(vendorId))
            .findFirst()
            .map(this::getVendor)
            .orElse(null);
    }

    @Override
    public List<VendorDTO> getVendorListFromIds(List<Integer> vendorIds) {
        return vendorIds.stream()
            .map(id -> vendors.get(id))
            .map(this::mapVendorDetailsToVendorDto)
            .toList();
    }

    private VendorDTO getVendor(int vendorId) {
        var vendorDetails = vendors.get(vendorId);
        return mapVendorDetailsToVendorDto(vendorDetails);
    }

    private VendorDTO mapVendorDetailsToVendorDto(VendorDetails vendorDetails) {
        return new VendorDTO(
            vendorDetails.getId(),
            vendorDetails.getName(),
            vendorDetails.getEmail(),
            vendorDetails.getUpi());
    }
}
