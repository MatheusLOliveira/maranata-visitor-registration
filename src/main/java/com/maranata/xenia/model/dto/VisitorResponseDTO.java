package com.maranata.xenia.model.dto;

import java.util.UUID;

public record VisitorResponseDTO(
        String name,
        String phone,
        Integer age,
        UUID responsibleVolunteer
) {
}
