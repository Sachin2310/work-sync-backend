package com.task.credmarg.worksync.vendor;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "vendor")
@NoArgsConstructor
@AllArgsConstructor
public class VendorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_generator")
    @SequenceGenerator(name = "vendor_generator", sequenceName = "vendor_seq", allocationSize = 1)
    private int id;

    private String name;
    private String email;
    private String upi;

    @JsonPropertyDescription("Foreign key from userDetails table")
    private String userEmail;
}
