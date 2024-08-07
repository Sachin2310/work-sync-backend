package com.task.credmarg.worksync.vendor.service;

import com.task.credmarg.worksync.vendor.VendorDetails;
import com.task.credmarg.worksync.vendor.VendorInformationMapper;
import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InMemoryVendorManagementService implements VendorManagementService {
    private final VendorInformationMapper vendorInformationMapper;
    Map<Integer, VendorDetails> vendors = new HashMap<>();

    @Override
    public VendorDTO addVendorDetails(VendorDTO vendorDTO) {
        VendorDetails vendorDetails = vendorInformationMapper.vendorDtoToVendorDetails(vendorDTO);
        vendors.put(vendorDetails.getId(), vendorDetails);
        return vendorDTO;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendors.values().stream()
                .map(vendorInformationMapper::vendorDetailsToVendorDto)
                .toList();
    }

    @Override
    public VendorDTO getVendorDetails(int vendorId) {
        return vendors.keySet().stream()
                .filter(id -> id.equals(vendorId))
                .findFirst()
                .map(this::getVendor)
                .orElse(null);
    }

    @Override
    public List<VendorDTO> getVendorListFromIds(List<Integer> vendorIds) {
        return vendorIds.stream()
                .map(id -> vendors.get(id))
                .map(vendorInformationMapper::vendorDetailsToVendorDto)
                .toList();
    }

    private VendorDTO getVendor(int vendorId) {
        var vendorDetails = vendors.get(vendorId);
        return vendorInformationMapper.vendorDetailsToVendorDto(vendorDetails);
    }
}
