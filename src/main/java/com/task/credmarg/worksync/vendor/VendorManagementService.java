package com.task.credmarg.worksync.vendor;

import java.util.List;

public interface VendorManagementService {
    VendorDTO addVendorDetails(VendorDTO vendorDTO);
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorDetails(String vendorId);
    List<VendorDTO> getVendorListFromIds(List<String> vendorIds);
}
