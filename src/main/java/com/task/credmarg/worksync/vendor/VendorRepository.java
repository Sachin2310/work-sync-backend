package com.task.credmarg.worksync.vendor;

import com.task.credmarg.worksync.vendor.models.VendorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorDetails,Integer> {
}
