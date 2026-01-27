package com.maranata.xenia.service;

import com.maranata.xenia.model.Volunteer;
import com.maranata.xenia.model.VolunteerRequestDTO;
import com.maranata.xenia.model.VolunteerResponseDTO;
import com.maranata.xenia.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VolunteerService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VolunteerRepository repository;

    public VolunteerResponseDTO createVolunteer(VolunteerRequestDTO volunteerRequest) {

        Volunteer newVolunteer = new Volunteer();

        newVolunteer.setName(volunteerRequest.name());
        newVolunteer.setPassword( passwordEncoder.encode(volunteerRequest.password()) );
        newVolunteer.setRole(volunteerRequest.role());

        repository.save(newVolunteer);

        return new VolunteerResponseDTO(
                newVolunteer.getId(),
                newVolunteer.getName(),
                newVolunteer.getRole()
        );
    }

    // TODO: Handle errors if not exist
    public VolunteerResponseDTO getVolunteerByName(String name) {
        Volunteer volunteer = repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found."));

       return new VolunteerResponseDTO(
         volunteer.getId(),
         volunteer.getName(),
         volunteer.getRole()
       );
    }

    public VolunteerResponseDTO getVolunteerById(UUID id) {
        Volunteer volunteer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found."));

        return new VolunteerResponseDTO(
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getRole()
        );
    }

    public List<VolunteerResponseDTO> getVolunteers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Volunteer> volunteersList = this.repository.findAll(pageable);

        return volunteersList.map(volunteer -> new VolunteerResponseDTO(
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getRole())
            ).stream().toList();
    }

    public VolunteerResponseDTO deleteVolunteerById(UUID id) {
        Volunteer volunteer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Volunteer not found."));

        repository.delete(volunteer);

        return new VolunteerResponseDTO(
                volunteer.getId(),
                volunteer.getName(),
                volunteer.getRole()
        );
    }

}
