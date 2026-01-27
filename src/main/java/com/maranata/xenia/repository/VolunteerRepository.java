package com.maranata.xenia.repository;

import com.maranata.xenia.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VolunteerRepository extends JpaRepository<Volunteer, UUID> {

    Optional<Volunteer> findByName(String name);

}

