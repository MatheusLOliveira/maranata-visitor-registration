package com.maranata.xenia.model;

import com.maranata.xenia.model.enums.VolunteerType;

import java.util.UUID;

public record VolunteerResponseDTO(
        UUID id,
        String name,
        VolunteerType role
) {
}
