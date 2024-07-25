package com.task.credmarg.worksync.vendor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
@RequiredArgsConstructor
public class VendorController {
    private final VendorManagementService vendorManagementService;
    //add controller advice

    @PostMapping
    ResponseEntity<VendorDTO> createVendorData(@RequestBody VendorDTO vendorDTO){
        return ResponseEntity.ok(vendorManagementService.addVendorDetails(vendorDTO));
    }
    @GetMapping
    ResponseEntity<List<VendorDTO>> getAllVendors(){
        return ResponseEntity.ok(vendorManagementService.getAllVendors());
    }
}
