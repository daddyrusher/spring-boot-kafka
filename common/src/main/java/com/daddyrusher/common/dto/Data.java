package com.daddyrusher.common.dto;

public record Data(
        Integer id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company) {
}