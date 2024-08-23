package com.task.credmarg.worksync.vendor.service;

import com.task.credmarg.worksync.vendor.VendorDetails;
import com.task.credmarg.worksync.vendor.VendorInformationMapper;
import com.task.credmarg.worksync.vendor.VendorRepository;
import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultVendorManagementService implements VendorManagementService {
    private final VendorInformationMapper vendorInformationMapper;
    private final VendorRepository vendorRepository;

    @Override
    public VendorDTO addVendorDetails(VendorDTO vendorDTO) {
        VendorDetails vendorDetails = vendorInformationMapper.vendorDtoToVendorDetails(vendorDTO);
        vendorDetails.setUserEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());
        var savedVendor = vendorRepository.save(vendorDetails);
        vendorDTO.setId(savedVendor.getId());
        return vendorDTO;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("userEmail: " + userEmail);
        return vendorRepository.findByUserEmail(userEmail).stream()
                .map(vendorInformationMapper::vendorDetailsToVendorDto)
                .toList();
    }

    @Override
    public VendorDTO getVendorDetails(int vendorId) {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return vendorRepository
                .findByIdAndUserEmail(vendorId, userEmail)
                .map(vendorInformationMapper::vendorDetailsToVendorDto)
                .orElse(null);
    }

    @Override
    public List<VendorDTO> getVendorListFromIds(List<Integer> vendorIds) {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return vendorRepository.findByUserEmailAndIdIn(userEmail, vendorIds).stream()
                .map(vendorInformationMapper::vendorDetailsToVendorDto)
                .toList();
    }
}
