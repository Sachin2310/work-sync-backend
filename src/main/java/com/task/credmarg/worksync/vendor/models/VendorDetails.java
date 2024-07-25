package com.task.credmarg.worksync.vendor.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VendorDetails{
    private String id;
    private String name;
    private String email;
    private String upi;
}
