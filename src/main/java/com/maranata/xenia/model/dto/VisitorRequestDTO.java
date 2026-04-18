package com.maranata.xenia.model.dto;

import com.maranata.xenia.model.Volunteer;
import com.maranata.xenia.model.enums.VisitorStatus;

import java.time.LocalDate;
import java.util.UUID;

public record VisitorRequestDTO(
        String name,
        String phone,
        Integer age,
        String firstFeedback,
        UUID responsibleVolunteer,
        LocalDate firstVisitDate,
        VisitorStatus visitorStatus
) {
}
