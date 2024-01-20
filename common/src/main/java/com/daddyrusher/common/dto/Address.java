package com.daddyrusher.common.dto;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Location geo) {
}
