package com.maranata.xenia.model;

import com.maranata.xenia.model.enums.VisitorStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "visitor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visitor {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String phone;

    private Integer age;

    private String firstFeedback;

    @ManyToOne
    @JoinColumn(name = "responsible_volunteer_id")
    private Volunteer responsibleVolunteer;

    private LocalDateTime creationAt;

    private LocalDate firstVisitDate;

    @Enumerated(EnumType.STRING)
    private VisitorStatus visitorStatus;

}
