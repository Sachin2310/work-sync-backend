package com.task.credmarg.worksync.vendor.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VendorDTO {
    private int id;
    private String name;
    private String email;
    private String upi;
}
