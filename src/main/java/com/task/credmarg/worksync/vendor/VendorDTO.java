package com.task.credmarg.worksync.vendor;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

public record VendorDTO(String id, String name, String email, String upi) {
    public VendorDTO{
        Objects.requireNonNull(name, "Name should not be null");
        if(!StringUtils.hasText(id)){
            id = UUID.randomUUID().toString();
        }
        if(!StringUtils.hasText(name)){
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
