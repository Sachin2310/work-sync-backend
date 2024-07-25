package com.task.credmarg.worksync.vendor;

import com.task.credmarg.worksync.employee.EmployeeDTO;

import java.util.List;

public interface VendorManagementService {
    VendorDTO addVendorDetails(VendorDTO vendorDTO);
    List<VendorDTO> getAllVendors();
    VendorDTO getVendorDetails(String vendorId);
}
