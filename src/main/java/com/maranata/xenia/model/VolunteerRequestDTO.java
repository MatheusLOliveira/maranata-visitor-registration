package com.maranata.xenia.model;

import com.maranata.xenia.model.enums.VolunteerType;

public record VolunteerRequestDTO(
        String name,
        String password,
        VolunteerType role
) {
}
