package com.task.credmarg.worksync.vendor;

import com.task.credmarg.worksync.vendor.controller.VendorDTO;

import java.util.List;

public interface VendorManagementService {
    VendorDTO addVendorDetails(VendorDTO vendorDTO);
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorDetails(int vendorId);
    List<VendorDTO> getVendorListFromIds(List<Integer> vendorIds);
}
