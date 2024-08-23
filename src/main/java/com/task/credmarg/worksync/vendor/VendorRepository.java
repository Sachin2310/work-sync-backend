package com.task.credmarg.worksync.vendor;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorDetails, Integer> {
    List<VendorDetails> findByUserEmail(String email);

    Optional<VendorDetails> findByIdAndUserEmail(int id, String userEmail);

    List<VendorDetails> findByUserEmailAndIdIn(String userEmail, List<Integer> ids);
}
