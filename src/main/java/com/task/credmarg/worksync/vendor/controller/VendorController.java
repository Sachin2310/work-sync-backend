package com.task.credmarg.worksync.vendor.controller;

import com.task.credmarg.worksync.vendor.service.VendorManagementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
@RequiredArgsConstructor
public class VendorController {
    private final VendorManagementService vendorManagementService;
    // add controller advice

    @PostMapping
    ResponseEntity<VendorDTO> createVendorData(@RequestBody VendorDTO vendorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorManagementService.addVendorDetails(vendorDTO));
    }

    @GetMapping
    ResponseEntity<List<VendorDTO>> getAllVendors() {
        return ResponseEntity.ok(vendorManagementService.getAllVendors());
    }

    @PostMapping("/list")
    ResponseEntity<List<VendorDTO>> getParticularVendor(@RequestBody List<Integer> vendorIds) {
        return ResponseEntity.ok(vendorManagementService.getVendorListFromIds(vendorIds));
    }
}
