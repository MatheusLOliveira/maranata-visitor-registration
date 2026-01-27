package com.maranata.xenia.model;

import com.maranata.xenia.model.enums.VolunteerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "volunteer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE volunteer SET active = FALSE WHERE id = ?")
@SQLRestriction(value = "active = TRUE")
public class Volunteer {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private VolunteerType role;

}
