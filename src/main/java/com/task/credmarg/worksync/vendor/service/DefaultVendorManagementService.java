package com.task.credmarg.worksync.vendor.service;

import com.task.credmarg.worksync.vendor.VendorDetails;
import com.task.credmarg.worksync.vendor.VendorInformationMapper;
import com.task.credmarg.worksync.vendor.VendorRepository;
import com.task.credmarg.worksync.vendor.controller.VendorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultVendorManagementService implements VendorManagementService{
    private final VendorInformationMapper vendorInformationMapper;
    private final VendorRepository vendorRepository;

    @Override
    public VendorDTO addVendorDetails(VendorDTO vendorDTO) {
        VendorDetails vendorDetails = vendorInformationMapper.vendorDtoToVendorDetails(vendorDTO);
        vendorRepository.save(vendorDetails);
        vendorDTO.setId(vendorDetails.getId());
        return vendorDTO;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
            .stream()
            .map(vendorInformationMapper::vendorDetailsToVendorDto)
            .toList();
    }

    @Override
    public VendorDTO getVendorDetails(int vendorId) {
        return vendorRepository.findById(vendorId)
            .map(vendorInformationMapper::vendorDetailsToVendorDto)
            .orElse(null);
    }

    @Override
    public List<VendorDTO> getVendorListFromIds(List<Integer> vendorIds) {
        return vendorRepository.findAllById(vendorIds)
            .stream()
            .map(vendorInformationMapper::vendorDetailsToVendorDto)
            .toList();
    }

}
