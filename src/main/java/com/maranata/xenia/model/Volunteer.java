package com.maranata.xenia.model;

import com.maranata.xenia.model.enums.VolunteerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "volunteer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private VolunteerType role;

}
